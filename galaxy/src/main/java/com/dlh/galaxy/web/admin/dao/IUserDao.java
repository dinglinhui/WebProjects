package com.dlh.galaxy.web.admin.dao;

import com.dlh.galaxy.web.admin.model.UserEntity;

/**
 * @author dinglinhui
 */
public interface IUserDao {
	
	public boolean isExist(UserEntity user);
	
	public boolean isUser(UserEntity user);

	public boolean insert(UserEntity user);
}
