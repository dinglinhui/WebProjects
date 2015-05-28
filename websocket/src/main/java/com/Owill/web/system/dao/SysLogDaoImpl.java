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
import com.Owill.web.system.entity.SysLog;
import com.Owill.web.base.tools.StringUtils;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Repository("SysLogDao")
public class SysLogDaoImpl extends BaseDaoImpl<SysLog, Long> implements
		SysLogDao {

	/**  */
	public List<SysLog> query(QueryParam param) {

		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "log");

		String[] sort_cols = { "id", "op.id", "created", "level", "info" };

		if (param.getSortDir().equals("desc")) {
			dc.addOrder(Order.desc("log."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		} else {
			dc.addOrder(Order.asc("log."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		}

		if (StringUtils.isNotEmpty(param.getSearchKey())) {
			dc.add(Restrictions.like("log.op.name", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("log.level", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("log.info", "%" + param.getSearchKey()
					+ "%"));
		}
		
		dc.add(Restrictions.eq("log.enable", true));

		return find(dc, param.getPaging());
	}

	/**  */
	public Class<SysLog> getType() {

		return SysLog.class;
	}

}
