/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.service;

import java.io.Serializable;
import java.util.List;

import com.Owill.web.base.dao.BaseDao;
import com.Owill.web.base.entity.Paging;
import com.Owill.web.base.entity.QueryParam;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public abstract class BaseServiceImpl<T, I extends Serializable> {
	
	public abstract BaseDao<T, I> getDao();

	/**  */
	public Boolean delete(I id) {
		
		try {
			
			getDao().deleteById(id);
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}

	/**  */
	public Boolean deleteLogic(I id) {
		
		try {
			
			getDao().deleteLogicById(id);
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}
	
	/**  */
	public Boolean recoverById(I id) {
		
		try {
			getDao().recoverById(id);
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}

	/**  */
	public T get(I id) {
		
		return getDao().get(id);
	}

	/**  */
	public I create(T obj) {
		
		return getDao().save(obj);
	}

	/**  */
	public void update(T obj) {
		
		getDao().update(obj);
	}

	/**  */
	public void saveOrUpdate(T obj) {
		
		//TODO
	}

	/**  */
	public List<T> query() {
		
		return getDao().query();
	}

	/**  */
	public List<T> query(Paging paging) {
	
		return getDao().query(paging);
	}

	/**  */
	public List<T> query(QueryParam param) {
		
		return getDao().query(param);
	}

}
