package com.tianyu.jty.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.common.persistence.Page;
import com.tianyu.jty.common.persistence.PropertyFilter;


/**
 * 基础service 所有service继承该类
 * 提供基础的实体操作方法
 * 使用HibernateDao<T,PK>进行业务对象的CRUD操作,子类需重载getEntityDao()函数提供该DAO.
 * @author ty
 * @date 2014年8月20日 上午11:21:14
 * @param <T>
 * @param <PK>
 */
public abstract class BaseService<T,PK extends Serializable > {
	
	/**
	 * 子类需要实现该方法，提供注入的dao
	 * @return
	 */
	public abstract HibernateDao<T, PK> getEntityDao();
	
	
	
	@Transactional(readOnly = true)
	public T get(final PK id) {
		return getEntityDao().find(id);
	}

	@Transactional(readOnly = false)
	public void save(final T entity) {
		getEntityDao().save(entity);
	}
	
	@Transactional(readOnly = false)
	public void update(final T entity){
		getEntityDao().save(entity);
	}
	
	@Transactional(readOnly = false)
	public void delete(final T entity){
		getEntityDao().delete(entity);
	}
	
	@Transactional(readOnly = false)
	public void delete(final PK id){
		getEntityDao().delete(id);
	}
	
	@Transactional(readOnly = true)
	public List<T> getAll(){
		return getEntityDao().findAll();
	}
	
	@Transactional(readOnly = true)
	public List<T> getAll(Boolean isCache){
		return getEntityDao().findAll(isCache);
	}
	
	
	public List<T> search(final List<PropertyFilter> filters){
		return getEntityDao().find(filters);
	}
	
	
	@Transactional(readOnly = true)
	public Page<T> search(final Page<T> page, final List<PropertyFilter> filters) {
		return getEntityDao().findPage(page, filters);
	}
	
	
/*	@Transactional(readOnly = true)
	public Page<T> search(final Page<T> page, final String hql,final Map<String, ?> values) {
		return getEntityDao().findPage(page, hql, values);
	}
	
	@Transactional(readOnly = true)
	public Page<T> search(final Page<T> page, final String hql,final Object... values) {
		return getEntityDao().findPage(page, hql, values);
	}*/
	
}
