package com.kingnod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingnod.dao.TaskDao;
import com.kingnod.entity.Task;

@Service
@Transactional(readOnly=true)
public class TaskService {
	
	@Autowired
	private TaskDao taskDao;
	/**
	 * 保存任务实体
	 * @param task
	 * @return
	 */
	 public Task save(Task task){
		 return taskDao.save(task);
	 }
}
