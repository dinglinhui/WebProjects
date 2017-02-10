/*package com.kingnod.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.kingnod.entity.JcnUser;
import com.kingnod.service.UserService;

//@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:springmvc-servlet.xml"})
//@ContextConfiguration(locations = {"/WEB-INF/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class) 
//@WebAppConfiguration
public class UserTest{//extends SpringTransactionalTestCase
	private Logger logger = LoggerFactory.getLogger(UserTest.class);
	//@Value("#{clientInfo['mapKey']}")
	//@Value("#{clientInfo.mapKey}")
	//private String mapKey;
	//@Autowired
	//private SqlDao sqlDao;
	//@Autowired
	
	@InjectMocks
	private UserService userService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void sf(){
		List<JcnUser> list =	userService.findAllUser(1000000L);
		logger.info("*****************"+list.size());
	}
	@After
	public void tearDown() {
		logger.info("测试结束");
	}

}
*/