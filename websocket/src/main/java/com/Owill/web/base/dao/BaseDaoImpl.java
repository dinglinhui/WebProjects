/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.Owill.web.base.entity.Paging;
import com.Owill.web.base.tools.StringUtils;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T, I extends Serializable> {

	@Autowired
	protected HibernateTemplate hibernateTemplate;

	/** 获取对象Class的方法 **/
	public abstract Class<T> getType();

	/**
	 * 保存对象
	 * 
	 * @param param
	 * @return
	 */
	public I save(T param) {
		
		return (I) hibernateTemplate.save(param);
	}

	/**
	 * 更新对象
	 * 
	 * @param param
	 */
	public void update(T param) {
		
		hibernateTemplate.update(param);
	}

	/**
	 * 通过id删除对象(物理删除)
	 * 
	 * @param param
	 */
	public void deleteById(I param) {

		StringBuffer hql = new StringBuffer("delete from "
				+ getType().getName() + " a where a.id=?");
		hibernateTemplate.bulkUpdate(hql.toString(), param);
	}

	/**
	 * 通过id删除对象(逻辑删除)
	 * 
	 * @param param
	 */
	public void deleteLogicById(I param) {

		updateState(false, param);
	}

	/**
	 * 通过id恢复被逻辑删除的对象
	 * 
	 * @param param
	 */
	public void recoverById(I param) {

		updateState(true, param);
	}

	/**
	 * 通过id获得实体
	 * 
	 * @param param
	 * @return
	 */
	public T get(I param) {

		return (T) hibernateTemplate.get(getType(), param);
	}

	/**
	 * 通过id懒加载实体
	 * 
	 * @param param
	 * @return
	 */
	public T load(I param) {

		return (T) hibernateTemplate.load(getType(), param);
	}

	/**
	 * 通过id删除批量对象(物理删除)
	 * 
	 * @param param
	 */
	public void batchDelete(final I[] param) {

		String hql = "delete from " + getType().getName() + " a where a.id in (?)";
		hibernateTemplate.bulkUpdate(hql, (T)param);
	}

	/**
	 * 通过id批量删除对象(逻辑删除)
	 * 
	 * @param param
	 */
	public void batchLogicDelete(String param) {

		updateButchState(false, param);
	}

	/**
	 * 通过id批量删除对象(逻辑删除)
	 * 
	 * @param param
	 */
	public void batchLogicDelete(I[] param) {

		updateButchState(false, param);
	}

	/**
	 * 通过id批量恢复对象(逻辑恢复)
	 * 
	 * @param param
	 *            []
	 */
	public void batchRecover(I[] param) {

		updateButchState(true, param);
	}

	/**
	 * 通过id批量恢复对象(逻辑恢复)
	 * 
	 * @param param
	 *            []
	 */
	public void batchRecover(String param) {

		updateButchState(true, param);
	}

	/**
	 * 逻辑删除对象和逻辑恢复对象
	 * 
	 * @param state
	 * @param paramId
	 */
	public void updateState(boolean state, I paramId) {
		String hql = "update " + getType().getName()
				+ " a set a.enable = ? where a.id = ?";
		Object[] values = { state, paramId };
		hibernateTemplate.bulkUpdate(hql, values);
	}

	/**
	 * 批量逻辑删除对象和批量逻辑恢复对象
	 * 
	 * @param state
	 * @param paramId
	 */
	public void updateButchState(boolean state, I[] params) {
		String hql = "update " + getType().getName()
				+ " a set a.enable = ? where a.id in (?)";
		Object[] values = { state, params };
		hibernateTemplate.bulkUpdate(hql, values);
	}

	/**
	 * 批量逻辑删除对象和批量逻辑恢复对象
	 * 
	 * @param state
	 * @param paramId
	 */
	public void updateButchState(boolean state, String params) {
		String[] ids = params.split(",");
		for (String str : ids) {
			String hql = "update " + getType().getName()
					+ " a set a.enable = ? where a.id = ?";
			Object[] values = { state, str };
			hibernateTemplate.bulkUpdate(hql, values);
		}
	}

	/**
	 * 保存或更新
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/**
	 * 批量保存或更新
	 * 
	 * @param entities
	 */
	public void saveOrUpdateAll(
			@SuppressWarnings("rawtypes") Collection entities) {
		//hibernateTemplate.saveOrUpdateAll(entities);
	}

	/** 返回所有列表的查询方法，不带分页 **/
	public List<T> query() {

		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("enable", true));
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	/** 返回所有已被逻辑删除列表的查询方法，不带分页 **/
	public List<T> queryDeleted() {

		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("enable", false));
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	/**
	 * 通过hql查询数据
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> query(String hql) {

		return (List<T>) hibernateTemplate.find(hql);
	}

	/**
	 * 通过其他条件的查询方法
	 * 
	 * @param alias
	 * @param other
	 * @return
	 */
	public List<T> query(String alias, String other) {

		StringBuffer hql = new StringBuffer("from ");
		hql.append(getType().getName());
		if (StringUtils.isNotEmpty(alias)) {
			hql.append(alias);
		}
		if (StringUtils.isNotEmpty(other)) {
			hql.append(" " + other);
		}

		return query(hql.toString());
	}

	public List<T> query(Paging paging) {

		DetachedCriteria criteria = DetachedCriteria.forClass(getType());
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("enable", true));
		return find(criteria, paging);
	}

	public List<T> find(DetachedCriteria criteria) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	@SuppressWarnings("rawtypes")
	public List<T> find(final DetachedCriteria criteria, final Paging paging) {

		return (List<T>) hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {

				Criteria executableCriteria = criteria
						.getExecutableCriteria(session);
				ScrollableResults scrollableResults = executableCriteria
						.scroll();
				scrollableResults.last();
				paging.setTotal(scrollableResults.getRowNumber() + 1);
				scrollableResults.close();
				executableCriteria.setFirstResult(paging.getFirstResult());
				executableCriteria.setMaxResults(paging.getPageSize());
				return executableCriteria.list();
			}
		});
	}

	public List<T> find(DetachedCriteria criteria, int firstResult,
			int maxResults) {

		return (List<T>) hibernateTemplate.findByCriteria(criteria, firstResult,
				maxResults);
	}

	public List<T> find(String queryString, Object[] values) {
		return (List<T>) hibernateTemplate.find(queryString, values);
	}

	public List<T> find(String queryString, Object values) {
		return (List<T>) hibernateTemplate.find(queryString, values);
	}

}
