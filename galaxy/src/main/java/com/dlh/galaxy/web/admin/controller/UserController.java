package com.dlh.galaxy.web.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlh.galaxy.web.admin.model.UserEntity;
import com.dlh.galaxy.web.admin.service.IUserService;

/**
 * @author dinglinhui
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> register(UserEntity user) {
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println(user.toString());
		boolean registerResult = userService.register(user);
		map.put("registerResult", registerResult);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(UserEntity user) {
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println(user.toString());
		boolean loginResult = userService.login(user);
		map.put("loginResult", loginResult);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
