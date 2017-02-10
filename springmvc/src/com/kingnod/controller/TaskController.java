package com.kingnod.controller;

import java.util.Date;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kingnod.entity.Task;
import com.kingnod.entity.JcnUser;
import com.kingnod.service.TaskService;
import com.kingnod.tool.Setting.ActionType;

@Controller
@RequestMapping("task")
public class TaskController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	/**
	 * 跳转到任务创建页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="create",method=RequestMethod.GET)
	public ModelAndView create(ModelAndView mv){
		mv.addObject("dep",Task.DepType.values());
		mv.addObject("action",ActionType.create );
		mv.setViewName("view/task/TaskForm");
		return mv;
	}
	
	/**
	 * 保存任务
	 * @param mv
	 * @param task
	 * @param task
	 * @return
	 */
	@RequestMapping(value="create",method=RequestMethod.POST)
	public ModelAndView create(ModelAndView mv,Task task,RedirectAttributes redirectAttributes){
		task.setLastUpdateDate(new Date());
		JcnUser user = new JcnUser();
		user.setId(4L);
		task.setUser(user);
		taskService.save(task);
		redirectAttributes.addFlashAttribute("message", "创建任务成功");
		mv.setViewName("view/task/TaskForm");
		return mv;
	}
}
