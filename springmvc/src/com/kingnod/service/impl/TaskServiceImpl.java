/*package com.kingnod.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingnod.dao.TaskDao;
import com.kingnod.entity.Task;
import com.kingnod.service.TaskService;

@Service
@Transactional(readOnly=true)
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDao taskDao;
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public Task save(Task task) {
		task.setCreateDate(new Date());
		task = taskDao.save(task);
		return task;
	}
	 
}
*/