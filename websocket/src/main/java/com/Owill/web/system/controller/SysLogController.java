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
import com.Owill.web.system.service.SysLogService;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
@Controller
@RequestMapping("/syslog")
public class SysLogController extends BaseController<SysLog, Long> {

	@Autowired
	private SysLogService service;
	
	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		return "syslog/list";
	}

	/**  */
	@Override
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session) {
		
		QueryParam param = new QueryParam(vo);
		List<SysLog> data = service.query(param);
		return getListResult(param, data);
	}

	/**  */
	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> delete(@RequestParam(value="id") Long id, HttpSession session) {

		Map<String, String> resp = new HashMap<String, String>();
		
		if (id == null) {
			
			resp.put("message", "不存在该数据,无法删除");
		} else {
			
			if (service.delete(id)) {
				
				resp.put("message", "日志删除成功");
			} else {
				
				resp.put("message", "日志删除失败");
			}
		}
		
		return resp;
	}

	/**  */
	@Override
	public String add(Model model, HttpSession session) {
		return null;
	}

	/**  */
	@Override
	public String add(@ModelAttribute SysLog obj, Model model, HttpSession session) {
		return null;
	}

	/**  */
	@Override
	public String update(@RequestParam(value="id") Long id, Model model, HttpSession session) {
		return null;
	}

}
