/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.tools;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.Owill.web.base.tools.ConstantValues;


/**
 * 系统拦截器
 * <hr/>
 * 
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {
	
	public static final boolean DEBUG = true;

	private static List<String> global = new ArrayList<String>();

	static {

		global.add("sysmage/login");
		global.add("sysmage/register");
		global.add("sysmage/check");
		global.add("sysmage/home");
		global.add("sysnews/news");
		global.add("sysmage/exit");
	}

	// 通用的url
	private List<String> commonUrl = new ArrayList<String>(global);

	private String trimUrl(String url) {
		// 去掉开头的"/"
		if (url.startsWith("/")) {
			url = url.substring(1);
		}
		// 去掉末尾的"/"
		if (url.endsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		return url;
	}

	/** 接口调用前拦截 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// 用户请求的Uri
		String url = request.getServletPath();
		url = trimUrl(url);

		// 如果是登录｜登出｜数据
		if (commonUrl.contains(url) || url.endsWith(".json")) {

			return true;
		}

		// 如果已经登录
		if (request.getSession() != null
				&& request.getSession().getAttribute(
						ConstantValues.USER) != null) {

			// 如果是首页
			if (url.equals("main")) {

				return true;
			}
			
			if (DEBUG) {
				
				return true;
			}
		}

		// 没有权限。返回主页
		response.sendRedirect(request.getContextPath()+"/sysmage/home");
		return false;
	}

	/** 接口调用后执行 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	/** 整个请求处理完毕回调方法 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

}
