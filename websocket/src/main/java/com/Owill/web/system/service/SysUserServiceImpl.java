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

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Owill.web.base.dao.BaseDao;
import com.Owill.web.base.service.BaseServiceImpl;
import com.Owill.web.system.dao.SysUserDao;
import com.Owill.web.system.entity.SysUser;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService{
	
	@Autowired
	private SysUserDao dao;

	/**  */
	@Override
	public boolean isUsedByUsername(String username) {

		return dao.isUsedByUsername(username);
	}

	/**  */
	@Override
	public SysUser findByUsernameAndPasswd(String username, String passwd) {
		
		return dao.findByUsernameAndPasswd(username, passwd);
	}

	/**  */
	@Override
	public void updateEmailPassword(Long id, String email, String password) {
		
		dao.updateEmailPassword(id, email, password);
	}

	/**  */
	@Override
	public BaseDao<SysUser, Long> getDao() {

		return dao;
	}

	/**  */
	@Override
	public void updateLastLogin(Long id) {

		dao.updateLastLogin(id);
	}

	/**  */
	@Override
	public void updateUser(SysUser obj) {
		
		SysUser user = dao.get(obj.getId());
		
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
		user.setSexMale(obj.isSexMale());
		
		dao.update(user);
	}

	/**  */
	@Override
	public List<SysUser> query(Set<Long> ids) {

		return dao.query(ids);
	}

}
