/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.system.dao;

import java.util.List;
import java.util.Set;

import com.Owill.web.base.dao.BaseDao;
import com.Owill.web.system.entity.SysUser;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public interface SysUserDao extends BaseDao<SysUser, Long> {

	/**
	 * 检测当前用户名知否已经被注册
	 * 
	 * @param username
	 * @return
	 */
	public boolean isUsedByUsername(String username);

	/**
	 * 通过用户名或者邮箱获取对象
	 * 
	 * @param username
	 * @return
	 */
	public SysUser findByUsernameAndPasswd(String username, String passwd);

	/**
	 * 更新用户邮箱密码
	 */
	public void updateEmailPassword(Long id, String email, String password);

	/**
	 * 更新最后一次登录时间
	 */
	public void updateLastLogin(Long id);
	
	/**
	 * 通过用户Set取得信息
	 * 
	 * @param id
	 * @return
	 */
	public List<SysUser> query(Set<Long> ids);

}
