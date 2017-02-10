package com.kingnod.task;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//@Component
public class ScheduledTask {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(ScheduledTask.class);
	@Value("#{clientInfo.app}")
	private boolean app;
	//@Autowired
	//private UserService userService;
	//@Value("#{clientInfo.startTime}")
//	private String startTime;
	//"0/5 * * * * ? "
	/*@Scheduled(cron="0/100 * * * * ? ") //间隔5秒执行  
    public void taskCycle(){  
		logger.info("定时器开始执行");  
        JcnUser us = new JcnUser();
        us.setCreateDate(new Date());
        us.setLastUpdateDate(new Date());
		us.setPassword("qqq"+(int)(Math.random()*100));
		us.setName("dongdong"+(int)(Math.random()*1000));
		//userService.save(us);//已经测试成功定时器中可以做事物操作
		
		
    }  */
}
