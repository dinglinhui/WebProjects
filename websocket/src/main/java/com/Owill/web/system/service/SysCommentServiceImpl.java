/**
 * Copyright 2015 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: SysCommentServiceImpl.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2015年3月9日
 * History:	
 */
package com.Owill.web.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Owill.web.base.dao.BaseDao;
import com.Owill.web.base.entity.QueryParam;
import com.Owill.web.base.service.BaseServiceImpl;
import com.Owill.web.system.dao.SysCommentDao;
import com.Owill.web.system.entity.SysComment;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2015年3月9日
 */
@Service("SysCommentService")
public class SysCommentServiceImpl extends BaseServiceImpl<SysComment, Long> implements SysCommentService {

	@Autowired
	private SysCommentDao dao;
	
	@Override
	public List<SysComment> query(QueryParam param) {
		// TODO Auto-generated method stub
		return dao.query(param);
	}
	
	@Override
	public List<SysComment> query(QueryParam param, Long id) {
		// TODO Auto-generated method stub
		return dao.query(param, id);
	}

	@Override
	public BaseDao<SysComment, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	public List<SysComment> query(String tag, Long id) {
		// TODO Auto-generated method stub
		return dao.query(tag, id);
	}
	
}
