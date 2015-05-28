/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.system.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.Owill.web.base.dao.BaseDaoImpl;
import com.Owill.web.base.entity.QueryParam;
import com.Owill.web.system.entity.SysUser;
import com.Owill.web.base.tools.StringUtils;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Repository("SysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser, Long> implements SysUserDao {

	/**  */
	@Override
	public Class<SysUser> getType() {

		return SysUser.class;
	}

	/**  */
	@Override
	public List<SysUser> query(QueryParam param) {

		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "user");

		String[] sort_cols = { "id", "username", "name", "email", "sexMale", "lastLogin", 
				  "created", "enable" };

		if (param.getSortDir().equals("desc")) {
			dc.addOrder(Order.desc("user."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		} else {
			dc.addOrder(Order.asc("user."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		}

		if (StringUtils.isNotEmpty(param.getSearchKey())) {
			
			StringBuffer hql = new StringBuffer();
			hql.append("username like '%" +param.getSearchKey() + "%'").append(" or ")
			.append("name like '%" +param.getSearchKey() + "%'").append(" or ")
			.append("email like '%" +param.getSearchKey() + "%'");
			
			if (param.getSearchKey().equals("男")) {
				hql.append(" or ").append("sexmale = true");
			}
			if (param.getSearchKey().equals("女")) {
				hql.append(" or ").append("sexmale = false");
			}
			
			dc.add(Restrictions.sqlRestriction(hql.toString()));
		}
		
		return find(dc, param.getPaging());
	}

	/**  */
	@Override
	public boolean isUsedByUsername(String username) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "user");
		dc.add(Restrictions.eq("user.username", username));
		
		List<SysUser> result = find(dc);
		
		if (result == null || result.size() == 0) {
			
			return false;
		}
		
		return true;
	}

	/**  */
	@Override
	public SysUser findByUsernameAndPasswd(final String username, final String passwd) {
		
		return hibernateTemplate.execute(new HibernateCallback<SysUser>() {

			@Override
			public SysUser doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createQuery("from SysUser where username = ? and password = ?");
				query.setParameter(0, username);
				query.setParameter(1, passwd);
				
				return (SysUser) query.uniqueResult();
			}
		});
	}

	/**  */
	@Override
	public void updateEmailPassword(Long id, String email, String password) {
		
		String hql = "update " + getType().getName()
				+ " a set a.email = ? and password = ? where a.id = ?";
		Object[] values = { email, password, id };
		hibernateTemplate.bulkUpdate(hql, values);
	}

	/**  */
	@Override
	public void updateLastLogin(Long id) {

		String hql = "update " + getType().getName()
				+ " a set a.lastLogin = ? where a.id = ?";
		
		Object[] values = {new Date(System.currentTimeMillis()), id};
		hibernateTemplate.bulkUpdate(hql, values);
	}

	/**  */
	@Override
	public List<SysUser> query(Set<Long> ids) {
		
		if (ids == null || ids.size() == 0) {
			
			return new ArrayList<SysUser>();
		}

		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "user");
		dc.add(Restrictions.in("user.id", ids));
	
		return find(dc);
	}

}
