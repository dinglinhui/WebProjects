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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.Owill.web.base.dao.BaseDaoImpl;
import com.Owill.web.base.entity.QueryParam;
import com.Owill.web.system.entity.SysCategory;
import com.Owill.web.base.tools.StringUtils;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Repository("SysCategoryDao")
public class SysCategoryDaoImpl extends BaseDaoImpl<SysCategory, Long> implements
		SysCategoryDao {

	/**  */
	@Override
	public List<SysCategory> query(QueryParam param) {

		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysCategory");

		String[] sort_cols = { "id", "name", "parentId.id", "created" };

		if (param.getSortDir().equals("desc")) {
			dc.addOrder(Order.desc("SysCategory."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		} else {
			dc.addOrder(Order.asc("SysCategory."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		}

		if (StringUtils.isNotEmpty(param.getSearchKey())) {
			dc.add(Restrictions.like("SysCategory.name", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("SysCategory.parentId.id", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("SysCategory.created", "%" + param.getSearchKey()
					+ "%"));
		}
		
		dc.add(Restrictions.eq("SysCategory.enable", true));

		return find(dc, param.getPaging());
	}

	/**  */
	@Override
	public List<SysCategory> query(QueryParam param,Long id){
		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysCategory");
		
		String[] sort_cols = {  "id", "name", "parentId.id", "created" };

		if(param!=null){
			if (param.getSortDir().equals("desc")) {
				dc.addOrder(Order.desc("SysCategory."
						+ sort_cols[param.getSortCol() % sort_cols.length]));
			} else {
				dc.addOrder(Order.asc("SysCategory."
						+ sort_cols[param.getSortCol() % sort_cols.length]));
			}
		}
		dc.add(Restrictions.eq("SysCategory.enable", true));
		dc.add(Restrictions.eq("SysCategory.parentId.id", id));
		if(param!=null){
			if (StringUtils.isNotEmpty(param.getSearchKey())) {
				dc.add(Restrictions.like("SysCategory.name", "%" + param.getSearchKey()
						+ "%"));
			}
			return find(dc, param.getPaging());
		}else{
			return find(dc);
		}
	}
	/**  */
	@Override
	public Class<SysCategory> getType() {

		return SysCategory.class;
	}

}
