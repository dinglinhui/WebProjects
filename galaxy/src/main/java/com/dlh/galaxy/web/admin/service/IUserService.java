package com.dlh.galaxy.web.admin.service;

import com.dlh.galaxy.web.admin.model.UserEntity;

/**
 * @author dinglinhui
 */
public interface IUserService {
	public boolean isExist(UserEntity user);
}
