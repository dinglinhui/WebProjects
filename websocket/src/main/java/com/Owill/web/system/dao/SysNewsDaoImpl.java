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
import com.Owill.web.system.entity.SysNews;
import com.Owill.web.base.tools.StringUtils;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Repository("SysNewsDao")
public class SysNewsDaoImpl extends BaseDaoImpl<SysNews, Long> implements
		SysNewsDao {

	/**  */
	@Override
	public List<SysNews> query(QueryParam param) {

		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysNews");

		String[] sort_cols = { "id", "title", "content", "type" , "user" , "created"};

		if (param.getSortDir().equals("desc")) {
			dc.addOrder(Order.desc("SysNews."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		} else {
			dc.addOrder(Order.asc("SysNews."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		}

		if (StringUtils.isNotEmpty(param.getSearchKey())) {
			dc.add(Restrictions.like("SysNews.title", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("SysNews.type", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("SysNews.created", "%" + param.getSearchKey()
					+ "%"));
		}
		
		dc.add(Restrictions.eq("SysNews.enable", true));

		return find(dc, param.getPaging());
	}

	
	/**  */
	@Override
	public Class<SysNews> getType() {

		return SysNews.class;
	}


	@Override
	public List<SysNews> query(SysNews news) {
		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysNews");
		if(news.getType().getName()!=null){
			dc.add(Restrictions.eq("SysNews.type.name", news.getType().getName()));
			dc.addOrder(Order.desc("id"));
		}
		
		// TODO Auto-generated method stub
		return null;
	}



}
