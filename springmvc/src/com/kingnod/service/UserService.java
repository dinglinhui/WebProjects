package com.kingnod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingnod.dao.UserDao;
import com.kingnod.entity.User;

@Service
@Transactional(readOnly=false)
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User findOne(Long id){
		return userDao.findOne(id);
	}
}
