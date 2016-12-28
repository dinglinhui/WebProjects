package com.dinglinhui.crystalstudio.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dinglinhui.crystalstudio.common.springmvc.SpringContextHolder;
import com.dinglinhui.crystalstudio.pojo.Criteria;
import com.dinglinhui.crystalstudio.service.BaseFieldsService;

/**
 * 系统初始化监听器
 * 
 * @author dinglinhui
 */
public class SystemInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		BaseFieldsService baseFieldsService = SpringContextHolder.getBean("baseFieldsServiceImpl");
		Criteria criteria = new Criteria();
		criteria.setOrderByClause(" field desc ,sort asc ");
		criteria.put("enabled", "1");
		servletContext.setAttribute("fields", baseFieldsService.selectAllByExample(criteria));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
