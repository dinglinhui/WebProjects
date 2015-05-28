package com.dlh.dao;

import com.dlh.model.UserEntity;

/**
 * @author dinglinhui
 */
public interface IUserDao {
	public boolean isExist(UserEntity user);
}
