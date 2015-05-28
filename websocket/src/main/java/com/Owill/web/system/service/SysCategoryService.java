/**
 * Copyright 2015 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: SysCategoryService.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2015年3月9日
 * History:	
 */
package com.Owill.web.system.service;

import java.util.List;

import com.Owill.web.base.entity.QueryParam;
import com.Owill.web.base.service.BaseService;
import com.Owill.web.system.entity.SysCategory;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2015年3月9日
 */
public interface SysCategoryService extends BaseService<SysCategory, Long>{

	/** 通过编码管理id搜索编码细项 并分页*/
	List<SysCategory> query(QueryParam param,Long id);
}
