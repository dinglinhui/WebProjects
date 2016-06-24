package com.dlh.service;

import com.dlh.web.model.UserEntity;

/**
 * @author dinglinhui
 */
public interface IUserService {
	public boolean isExist(UserEntity user);
}
