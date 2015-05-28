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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Owill.web.base.controller.BaseController;
import com.Owill.web.base.entity.QueryParam;
import com.Owill.web.base.tools.DataTableVO;
import com.Owill.web.system.entity.SysLog;
import com.Owill.web.system.entity.SysUser;
import com.Owill.web.system.service.SysUserService;
import com.Owill.web.base.tools.ConstantValues;
import com.Owill.web.base.tools.Log;
import com.Owill.web.base.tools.MD5;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends BaseController<SysUser, Long> {

	@Autowired
	private SysUserService service;

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		return "sysmage/sysuser/sysuser_list";
	}

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session) {

		writeLog(session, SysLog.GREEN, Log.USER_LIST);

		QueryParam param = new QueryParam(vo);
		List<SysUser> data = service.query(param);
		return getListResult(param, data);
	}

	/** 禁用用户 */
	@Override
	@RequestMapping(value = "/disable", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> delete(@RequestParam(value = "id") Long id,
			HttpSession session) {

		Map<String, String> resp = new HashMap<String, String>();

		if (id == null) {

			resp.put("message", "不存在该数据,无法禁用");

			return resp;
		}

		SysUser user = (SysUser) session.getAttribute(ConstantValues.USER);

		if (user.getId().equals(id)) {

			resp.put("message", "用户无法操作自己");

		} else {

			if (service.deleteLogic(id)) {

				writeLog(session, SysLog.YELLOW, Log.USER_DISABLE + id);
				resp.put("message", "用户禁用成功");
			} else {

				resp.put("message", "用户禁用失败");
			}
		}

		return resp;
	}

	/** 启用用户 */
	@RequestMapping(value = "/enable", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> enable(@RequestParam(value = "id") Long id,
			HttpSession session) {

		Map<String, String> resp = new HashMap<String, String>();

		if (id == null) {

			resp.put("message", "不存在该数据,无法启用");

			return resp;
		}

		SysUser user = (SysUser) session.getAttribute(ConstantValues.USER);

		if (user.getId().equals(id)) {

			resp.put("message", "用户无法操作自己");

		} else {

			if (service.recoverById(id)) {

				writeLog(session, SysLog.YELLOW, Log.USER_ENABLE + id);
				resp.put("message", "用户启用成功");
			} else {

				resp.put("message", "用户启用失败");
			}
		}

		return resp;
	}

	/**  */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, HttpSession session) {

		return "sysmage/sysuser/sysuser_add";
	}
	
	/**  */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute SysUser obj, Model model,
			HttpSession session) {

		Long id;

		if (obj == null) {

			model.addAttribute(ConstantValues.EDIT_FAILED, "添加用户失败");
			return "sysmage/sysuser/sysuser_add";
		}
		String s=MD5.getMD5String(obj.getPassword());
		obj.setPassword(s);
		try {

			if (obj.getId() == null) {
	
				id = service.create(obj);
				writeLog(session, SysLog.YELLOW, Log.USER_ADD + id);
				model.addAttribute(ConstantValues.EDIT_SUCC, "添加用户成功");
			} else {
	
				id = obj.getId();
				service.updateUser(obj);
				writeLog(session, SysLog.YELLOW, Log.USER_UPDATE + id);
				model.addAttribute(ConstantValues.EDIT_SUCC, "更新用户成功");
			}
		} catch (Exception e) {
			
			model.addAttribute(ConstantValues.EDIT_FAILED, "操作失败");
		}

		return "sysmage/sysuser/sysuser_add";
	}

	/**  */
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(value = "id") Long id, Model model,
			HttpSession session) {

		SysUser user = service.get(id);
		model.addAttribute("user", user);

		return "sysuser/add";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public @ResponseBody 
	Map<String, Object> checkUsername(@RequestParam(value = "username") String username, HttpSession session) {
		
		boolean exist = service.isUsedByUsername(username);
		
		Map<String, Object> resp = new HashMap<String, Object>();
		
		if (exist) {
			
			resp.put("exist", true);
		} else {
			
			resp.put("exist", false);
		}
		
		return resp;
	}
}
