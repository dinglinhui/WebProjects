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
import java.util.List;

import com.Owill.web.base.entity.Paging;
import com.Owill.web.base.entity.QueryParam;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public interface BaseDao<T, I extends Serializable> {

	/**
	 * 保存对象
	 * 
	 * @param param
	 * @return
	 */
	public I save(T param);

	/**
	 * 直接更新对象(默认根据主键)
	 * 
	 * @param param
	 */
	public void update(T param);

	/**
	 * 通过id删除对象(物理删除)
	 * 
	 * @param param
	 */
	public void deleteById(I param);

	/**
	 * 通过id删除对象(逻辑删除)
	 * 
	 * @param param
	 */
	public void deleteLogicById(I param);

	/**
	 * 通过id恢复被逻辑删除的对象
	 * 
	 * @param param
	 */
	public void recoverById(I param);

	/**
	 * 通过id获得实体
	 * 
	 * @param param
	 * @return
	 */
	public T get(I param);

	/**
	 * 通过id懒加载实体
	 * 
	 * @param param
	 * @return
	 */
	public T load(I param);

	/**
	 * 通过id删除批量对象(物理删除)
	 * 
	 * @param param
	 */
	public void batchDelete(I[] param);

	/**
	 * 通过id批量删除对象(逻辑删除)
	 * 
	 * @param param
	 */
	public void batchLogicDelete(I[] param);

	/**
	 * 通过id批量删除对象(逻辑删除)
	 * 
	 * @param param
	 */
	public void batchLogicDelete(String param);

	/**
	 * 通过id批量恢复对象(逻辑恢复)
	 * 
	 * @param param
	 *            []
	 */
	public void batchRecover(I[] param);

	/**
	 * 通过id批量恢复对象(逻辑恢复)
	 * 
	 * @param param
	 *            []
	 */
	public void batchRecover(String param);

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<T> query();
	
	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<T> query(Paging paging);
	
	/**
	 * 带分页查询
	 * @param param
	 * @return
	 */
	public List<T> query(QueryParam param);
}
