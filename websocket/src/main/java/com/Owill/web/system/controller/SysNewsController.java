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

import java.util.ArrayList;
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
import com.Owill.web.system.entity.SysComment;
import com.Owill.web.system.entity.SysNews;
import com.Owill.web.system.entity.SysLog;
import com.Owill.web.system.service.SysCategoryService;
import com.Owill.web.system.service.SysCommentService;
import com.Owill.web.system.service.SysNewsService;
import com.Owill.web.base.tools.ConstantValues;
import com.Owill.web.base.tools.Log;

/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Controller
@RequestMapping("/sysnews")
public class SysNewsController extends BaseController<SysNews, Long> {

	@Autowired
	private SysNewsService service;
	@Autowired
	private SysCategoryService typeservice;
	@Autowired
	private SysCommentService commentservice;
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news(@RequestParam("id") Long newsid, Model model, HttpSession session) {
		writeLog(session, SysLog.GREEN, Log.USER_LIST);
		SysNews news = service.get(newsid);
		List<SysComment> comment=commentservice.query("support_desc", newsid);
		model.addAttribute("comment", comment);
		news.setCount(news.getCount()+1);
		writeLog(session, SysLog.YELLOW, Log.USER_UPDATE);
		service.update(news);
		model.addAttribute("news",news);
		return "sysmage/sysnews/news";
	}

	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public String news(@ModelAttribute SysComment obj, Model model) {
		commentservice.create(obj);
		SysNews news = service.get(obj.getParentId());
		List<SysComment> comment=commentservice.query("support_desc", obj.getParentId());
		model.addAttribute("comment", comment);
		news.setCount(news.getCount()+1);
		service.update(news);
		model.addAttribute("news",news);
		return "sysmage/sysnews/news";
	}

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		return "sysmage/sysnews/sysnews_list";
	}

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session) {
		writeLog(session, SysLog.GREEN, Log.USER_LIST);

		QueryParam param = new QueryParam(vo);
		List<SysNews> data = service.query(param);
		return getListResult(param, data);
	}


	/**  */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, HttpSession session) {

		Long id;
		List<SysCategory> type = typeservice.query();
		List<SysCategory> typename = new ArrayList<SysCategory>();
		for(int i=0;i<type.size();i++){
			if(type.get(i).getParentId()!=null){
				id=type.get(i).getParentId().getId();
				if(id == 1){
					typename.add(type.get(i));
				}
			}
		}
		model.addAttribute("typename", typename);
		return "sysmage/sysnews/sysnews_add";
	}
	
	/**  */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute SysNews obj, Model model,
			HttpSession session) {

		Long id;

		if (obj == null) {

			model.addAttribute(ConstantValues.EDIT_FAILED, "添加失败");
			return "sysmage/sysnews/sysnews_add";
		}
		try {

			if (obj.getId() == null) {
	
				//obj.setUser(session.getAttribute("currentUser"));
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

		return "sysmage/sysnews/sysnews_add";
	}


	/**  */
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(value = "id") Long id, Model model,
			HttpSession session) {
		SysNews news = service.get(id);
		model.addAttribute("news", news);
		
		Long typeid;
		List<SysCategory> type = typeservice.query();
		List<SysCategory> typename = new ArrayList<SysCategory>();
		for(int i=0;i<type.size();i++){
			if(type.get(i).getParentId()!=null){
				typeid=type.get(i).getParentId().getId();
				if(typeid == 1){
					typename.add(type.get(i));
				}
			}
		}
		model.addAttribute("typename", typename);

		return "sysmage/sysnews/sysnews_add";
	}
	
	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Map<String, String> delete(@RequestParam(value = "id")Long id, HttpSession session) {
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
