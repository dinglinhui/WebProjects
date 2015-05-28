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
import com.Owill.web.system.entity.SysComment;
import com.Owill.web.base.tools.StringUtils;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Repository("SysCommentDao")
public class SysCommentDaoImpl extends BaseDaoImpl<SysComment, Long> implements SysCommentDao {

	/**  */
	public List<SysComment> query(QueryParam param) {

		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysComment");

		String[] sort_cols = { "id", "comment", "parentId", "created" , "support" , "against"};

		if (param.getSortDir().equals("desc")) {
			dc.addOrder(Order.desc("SysComment."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		} else {
			dc.addOrder(Order.asc("SysComment."
					+ sort_cols[param.getSortCol() % sort_cols.length]));
		}

		if (StringUtils.isNotEmpty(param.getSearchKey())) {
			dc.add(Restrictions.like("SysComment.comment", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("SysComment.parentId", "%" + param.getSearchKey()
					+ "%"));
			dc.add(Restrictions.like("SysComment.created", "%" + param.getSearchKey()
					+ "%"));
		}
		
		dc.add(Restrictions.eq("SysComment.enable", true));

		return find(dc, param.getPaging());
	}

	/**  */
	public List<SysComment> query(QueryParam param,Long id){
		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysComment");
		
		String[] sort_cols = {  "id", "comment", "parentId", "created" , "support" , "against"};

		if(param!=null){
			if (param.getSortDir().equals("desc")) {
				dc.addOrder(Order.desc("SysComment."
						+ sort_cols[param.getSortCol() % sort_cols.length]));
			} else {
				dc.addOrder(Order.asc("SysComment."
						+ sort_cols[param.getSortCol() % sort_cols.length]));
			}
		}
		dc.add(Restrictions.eq("SysComment.enable", true));
		dc.add(Restrictions.eq("SysComment.parentId", id));
		if(param!=null){
			if (StringUtils.isNotEmpty(param.getSearchKey())) {
				dc.add(Restrictions.like("SysComment.comment", "%" + param.getSearchKey()
						+ "%"));
			}
			return find(dc, param.getPaging());
		}else{
			return find(dc);
		}
	}
	
	/**  */
	public List<SysComment> query(String tag,Long id){
		DetachedCriteria dc = DetachedCriteria.forClass(getType(), "SysComment");
		
		String[] sort_cols = {  "id", "comment", "parentId", "created" , "support" , "against"};

		if(tag!=null){
			for(int i=0;i<sort_cols.length;i++){
				if(tag.equals(sort_cols[i]+"_desc")){
					dc.addOrder(Order.desc("SysComment."
							+ sort_cols[i]));
				}else{
					dc.addOrder(Order.asc("SysComment."
							+ sort_cols[i]));
				}
			}
		}
		dc.add(Restrictions.eq("SysComment.enable", true));
		dc.add(Restrictions.eq("SysComment.parentId", id));
		return find(dc);
	}

	@Override
	public Class<SysComment> getType() {
		// TODO Auto-generated method stub
		return SysComment.class;
	}


}
