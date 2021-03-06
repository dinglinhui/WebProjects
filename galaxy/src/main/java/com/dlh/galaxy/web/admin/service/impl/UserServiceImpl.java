package com.dlh.galaxy.web.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlh.galaxy.web.admin.dao.IUserDao;
import com.dlh.galaxy.web.admin.model.UserEntity;
import com.dlh.galaxy.web.admin.service.IUserService;

/**
 * @author dinglinhui
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public boolean isExist(UserEntity user) {
		return userDao.isExist(user);
	}
	
	@Override
	public boolean login(UserEntity user) {
		return userDao.isUser(user);
	}

	@Override
	public boolean register(UserEntity user) {
		if (userDao.isExist(user))
			return false;
		else
			return userDao.insert(user);
	}

}
