/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.Owill.web.system.entity.SysCategory;
import com.Owill.web.system.entity.SysLog;
import com.Owill.web.system.entity.SysNews;
import com.Owill.web.system.entity.SysUser;
import com.Owill.web.system.service.SysCategoryService;
import com.Owill.web.system.service.SysLogService;
import com.Owill.web.system.service.SysNewsService;
import com.Owill.web.system.service.SysUserService;
import com.Owill.web.base.tools.ConstantValues;
import com.Owill.web.base.tools.Log;
import com.Owill.web.base.tools.MD5;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Controller
@RequestMapping("/sysmage")
public class SystemController {

	@Autowired
	private SysUserService userService;
	@Autowired
	private SysLogService logService;
	@Autowired
	private SysNewsService newsservice;
	@Autowired
	private SysCategoryService typeservice;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status, HttpSession session) {

		SysUser user = (SysUser) session.getAttribute(ConstantValues.USER);
		logService.write(SysLog.GREEN, user, Log.USER_LOGOUT);
		status.setComplete();
		session.removeAttribute(ConstantValues.USER);
		
		return "sysmage/home/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login_soft";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,
			HttpSession session, HttpServletRequest request) {
		
		SysUser user = userService.findByUsernameAndPasswd(username, MD5.getMD5String(password));
        if (user == null) {

            model.addAttribute("username", username);
            model.addAttribute("message", "用户名和密码不匹配！");
            return "sysmage/home/index";
        }

        if (!user.isEnable()) {

            model.addAttribute("message", "该账号已被禁用！");
            return "sysmage/home/index";
        }
        
        user.setLastLogin(new Date(System.currentTimeMillis()));
        userService.updateLastLogin(user.getId());

        // USER的属性放到Session属性列表中
        session.setAttribute(ConstantValues.USER, user);
        logService.write(SysLog.GREEN, user, Log.USER_LOGIN);
        
        // 项目根目录：/Bootstrap
        //String root = request.getContextPath();
        
        //TODO 登录后续工作
        model.addAttribute("username", username);
        model.addAttribute("message", "登录成功！");
        return "sysmage/home/index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		List<SysNews> news = newsservice.query();
		model.addAttribute("news", news);
		List<SysCategory> newstype=typeservice.query();
		model.addAttribute("newstype", newstype);
		return "sysmage/home/index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute SysUser obj, HttpSession session, Model model) {
		Long id;

/*		if (obj == null) {
			return "login_soft";
		}*/
	
		if (obj.getId() == null) {
			System.out.println(obj.getPassword());
			String s=MD5.getMD5String(obj.getPassword());
			obj.setPassword(s);
			id = userService.create(obj);
			obj.setId(id);
			logService.write(SysLog.GREEN, obj, Log.USER_REGISTER + id);
			model.addAttribute(ConstantValues.EDIT_SUCC, "注册成功");
			model.addAttribute("message", "注册成功");
		}

		return "sysmage/home/index";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public @ResponseBody 
	Map<String, Object> checkUsername(@RequestParam(value = "username") String username,
			HttpServletRequest request,HttpSession session) {
		
		boolean exist = userService.isUsedByUsername(username);
		
		Map<String, Object> resp = new HashMap<String, Object>();
		if (exist) {
			
			resp.put("exist", true);
		} else {
			
			resp.put("exist", false);
		}
		
		if(request.getSession() != null
				&& request.getSession().getAttribute(
						ConstantValues.USER) != null){
			SysUser user=(SysUser)request.getSession().getAttribute(
					ConstantValues.USER);
			resp.put("logininfo", user.getUsername());
		}else{
			resp.put("logininfo", "游客");
		}
		return resp;
	}

}
