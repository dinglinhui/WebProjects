package com.dlh.dao;

import com.dlh.web.model.UserEntity;

/**
 * @author dinglinhui
 */
public interface IUserDao {
	public boolean isExist(UserEntity user);
}
