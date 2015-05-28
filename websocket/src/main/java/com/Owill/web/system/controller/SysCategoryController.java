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
import com.Owill.web.system.entity.SysCategory;
import com.Owill.web.system.entity.SysLog;
import com.Owill.web.system.service.SysCategoryService;
import com.Owill.web.base.tools.ConstantValues;
import com.Owill.web.base.tools.Log;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Controller
@RequestMapping("/syscategory")
public class SysCategoryController extends BaseController<SysCategory, Long> {

	@Autowired
	private SysCategoryService service;

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		return "sysmage/syscategory/syscategory_list";
	}

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session) {
		writeLog(session, SysLog.GREEN, Log.USER_LIST);

		QueryParam param = new QueryParam(vo);
		List<SysCategory> data = service.query(param);
		return getListResult(param, data);
	}


	/**  */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, HttpSession session) {
		
		List<SysCategory> typename = service.query();
		model.addAttribute("typename", typename);
		return "sysmage/syscategory/syscategory_add";
	}
	
	/**  */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute SysCategory obj, Model model,
			HttpSession session) {

		Long id;

		if (obj == null) {

			model.addAttribute(ConstantValues.EDIT_FAILED, "添加失败");
			return "sysmage/syscategory/syscategory_add";
		}
		try {

			if (obj.getId() == null) {
				if(obj.getParentId().getId()==0){
					obj.setParentId(null);
				}
				id = service.create(obj);
				writeLog(session, SysLog.YELLOW, Log.USER_ADD + id);
				model.addAttribute(ConstantValues.EDIT_SUCC, "添加成功");
			} else {
	
				id = obj.getId();
				service.update(obj);
				writeLog(session, SysLog.YELLOW, Log.USER_UPDATE + id);
				model.addAttribute(ConstantValues.EDIT_SUCC, "更新成功");
			}
		} catch (Exception e) {
			
			model.addAttribute(ConstantValues.EDIT_FAILED, "操作失败");
		}

		return "sysmage/syscategory/syscategory_add";
	}

	/**  */
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(value = "id") Long id, Model model,
			HttpSession session) {

		SysCategory category = service.get(id);
		model.addAttribute("category", category);
		
		List<SysCategory> typename = service.query();
		model.addAttribute("typename", typename);

		return "sysmage/syscategory/syscategory_add";
	}

	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Map<String, String> delete(Long id, HttpSession session) {
		// TODO Auto-generated method stub
		Map<String, String> resp = new HashMap<String, String>();
		if (service.deleteLogic(id)) {

			writeLog(session, SysLog.YELLOW, Log.USER_ENABLE + id);
			resp.put("message", "操作成功");
		} else {

			resp.put("message", "操作失败");
		}
		return resp;
	}
	
}
