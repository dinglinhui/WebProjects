/**
 * 
 */
package com.dlh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlh.dao.IUserDao;
import com.dlh.model.UserEntity;
import com.dlh.service.IUserService;

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

}
