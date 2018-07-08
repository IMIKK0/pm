package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Task;
import com.pm.dao.ITaskDao;
import com.pm.service.ITaskService;

@Service
public class TaskService implements ITaskService {
	@Resource
	private ITaskDao taskDao;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void addTask(Task task) {
		taskDao.addTask(task);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void deleteTask(Task task) {
		taskDao.deleteTask(task);
		
	}

	@Override
	public Task findTaskByid(int id) {
		
		return taskDao.findTaskByid(id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void updateTask(Task task) {
		taskDao.updateTask(task);
		
	}

	@Override
	public int totalCount() {		
		return taskDao.totalCount();
	}

	@Override
	public List<Task> findTask(int start, int pageSize) {		
		return taskDao.findTask(start, pageSize);
	}
	//Ä£ºý²éÑ¯
	@Override
	public List<Task> searchTask(Task task) {		
		return taskDao.searchTask(task);
	}

}
