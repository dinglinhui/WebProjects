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
import com.Owill.web.system.entity.SysComment;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2015年3月9日
 */
public interface SysCommentService extends BaseService<SysComment, Long>{

	/** 通过newsid搜索新闻评论 并分页*/
	List<SysComment> query(QueryParam param,Long id);
	/** 通过(排序字段+_desc或者不加)+要查询的父ID（可以是新闻ID，也可以是上一级评论ID）搜索新闻评论*/
	List<SysComment> query(String tag,Long id);
}
