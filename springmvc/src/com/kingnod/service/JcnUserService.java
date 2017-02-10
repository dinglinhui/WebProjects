package com.kingnod.service;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingnod.dao.ClassesDao;
import com.kingnod.dao.JcnUserDao;
import com.kingnod.entity.Classes;
import com.kingnod.entity.JcnUser;

@Service("jcnUserService")
@Transactional(readOnly=true)
public class JcnUserService {

	@Autowired
	private JcnUserDao userDao;
	@Autowired
	private ClassesDao classesDao;
	public List<JcnUser> findAllUser(Long id){
		System.out.println("*****service层**"+userDao);
		return userDao.findAllJcnUser(id);
	}
	@Transactional(readOnly=false)
	public JcnUser save(JcnUser user){
	 return	userDao.save(user);
	}
	/**
	 * 分页查询
	 * @param sp
	 * @param page
	 * @return
	 */
	public Page<JcnUser> pageUser(Specification<JcnUser> sp,PageRequest page){
		return userDao.findAll(sp,page);
	}
	@Cacheable(value = "entity:user", key="'cpy:user:' + #id+''")
	public JcnUser findOne(Long id){
		System.out.println("*****service层**"+userDao);
		return userDao.findOne(id);
	}
	
	@CachePut(value = "entity:user", key="'cpy:user:' + #id+''")
	//@CacheEvict(value = "entity:user", key="'cpy:user:' + #id+''")
	@Transactional(readOnly=false)
	public JcnUser updateOne(Long id){
		JcnUser user = userDao.findOne(id);
		user.setName(user.getName()+"_S");
	    user = userDao.save(user);
		return user;
	}
	@Transactional(readOnly=false)
	public Classes saveClasses(){
		Classes c = new Classes();
		List<JcnUser> list = (List<JcnUser>) userDao.findAll();
		c.setCode("c_1002");
		c.setName("网络102");
		c.setCreateDate(new Date());
		c.setLastUpdateDate(new Date());
		c.setList(list);
	    c=classesDao.save(c);
	    return c;
	}
	//@Transactional(readOnly=false)
	public Classes findOneClasses(Long id){
		Classes c= classesDao.findOne(id);
		//List<User> list = c.getList();
		//System.out.println("*********"+list.size());
		return c;
	}
	@Transactional(readOnly=false)
	public void de(Long id){
		classesDao.delete(id);
	}
}
