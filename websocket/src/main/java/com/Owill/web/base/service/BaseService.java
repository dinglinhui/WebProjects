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

import com.Owill.web.base.entity.Paging;
import com.Owill.web.base.entity.QueryParam;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public abstract interface BaseService<T, I extends Serializable> {

	/**
	 * 物理删除
	 * @param id
	 * @return
	 */
	public Boolean delete(I id);

	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	public Boolean deleteLogic(I id);
	
	/**
	 * 通过id恢复被逻辑删除的对象
	 * 
	 * @param param
	 */
	public Boolean recoverById(I id);

	/**
	 * 获得实体
	 * @param id
	 * @return
	 */
	public T get(I id);

	/**
	 * 保存实体
	 * @param obj
	 * @return
	 */
	public I create(T obj);

	/**
	 * 更新实体
	 * @param obj
	 */
	public void update(T obj);

	/**
	 * 保存或更新实体
	 * @param obj
	 */
	public void saveOrUpdate(T obj);

	/**
	 * 查询所有
	 * @return
	 */
	public List<T> query();

	/**
	 * 查询所有,带分页
	 * @param paginator
	 * @return
	 */
	public List<T> query(Paging paging);

	/**
	 * 查询所有,带条件
	 * @param param
	 * @return
	 */
	public List<T> query(QueryParam param);
}
