/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Owill.web.base.entity.QueryParam;
import com.Owill.web.base.tools.DataTableVO;
import com.Owill.web.system.entity.SysUser;
import com.Owill.web.system.service.SysLogService;
import com.Owill.web.base.tools.ConstantValues;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public abstract class BaseController<T, I extends Serializable> {
	
	@Autowired
	private SysLogService logService;
	
	/**
	 * 写日志
	 *
	 * @param session
	 * @param level 等级
	 * @param message 消息
	 */
	protected void writeLog(HttpSession session, String level, String message) {
		
		SysUser user = (SysUser) session.getAttribute(ConstantValues.USER);
		logService.write(level, user, message);
	}
	
	/**
	 * 返回List生成的Map,包括总数据量,显示数据量,数据源,?
	 * @param param
	 * @param data
	 * @return
	 */
	protected Map<String, Object> getListResult(QueryParam param, List<T> data) {
		
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("iTotalRecords", param.getPaging().getTotal());
		resp.put("iTotalDisplayRecords", param.getPaging().getTotal());
		resp.put("aaData", data);
		resp.put("sEcho", param.getsEcho());
		
		return resp;
	}

	/**
	 * 获取列表
	 * @param model
	 * @return 页面地址
	 */
	public abstract String list(Model model);
	
	/**
	 * 获取列表数据 > <font color="#FF0000">请调用{@link getListResult}作为返回数据</font>
	 * @param vo
	 * @param session
	 * @return 返回Map,请直接调用getListResult()或者参考其写法.
	 */
	public abstract @ResponseBody 
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session);
	
	/**
	 * 删除
	 * @param id
	 * @param session
	 * @return message 返回消息
	 */
	public abstract @ResponseBody
	Map<String, String> delete(@RequestParam(value = "id") I id, HttpSession session);
	
	/**
	 * 添加数据
	 * @param model
	 * @param session
	 * @return 页面地址
	 */
	public abstract String add(Model model, HttpSession session);
	
	/**
	 * 添加数据到数据库
	 * @param obj
	 * @param model
	 * @param session
	 * @return 保存后的页面地址
	 */
	public abstract String add(@ModelAttribute T obj, Model model, HttpSession session);
	
	/**
	 * 更新数据
	 * @param id
	 * @param model
	 * @param session
	 * @return 页面地址
	 */
	public abstract String update(@RequestParam(value = "id") I id, Model model, HttpSession session); 
}
