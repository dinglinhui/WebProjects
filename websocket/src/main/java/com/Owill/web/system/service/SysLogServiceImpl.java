/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Owill.web.base.dao.BaseDao;
import com.Owill.web.base.service.BaseServiceImpl;
import com.Owill.web.system.dao.SysLogDao;
import com.Owill.web.system.entity.SysLog;
import com.Owill.web.system.entity.SysUser;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Service("SysLogService")
public class SysLogServiceImpl extends BaseServiceImpl<SysLog, Long> implements SysLogService{

	@Autowired
	private SysLogDao dao;
	
	/**  */
	@Override
	public BaseDao<SysLog, Long> getDao() {

		return dao;
	}

	/**  */
	@Override
	public void write(String level, SysUser op, String info) {

		SysLog log = new SysLog();
		log.setInfo(info);
		log.setOp(op);
		log.setLevel(level);
		dao.save(log);
	}

}
