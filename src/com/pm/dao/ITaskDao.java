package com.pm.dao;

import java.util.List;

import com.pm.bean.Task;
public interface ITaskDao {
	//添加
	public void addTask(Task task);
	//删除
	public void deleteTask(Task task);
	//修改之前得查询
	public Task findTaskByid(int id);
	//修改
	public void updateTask(Task task);
	//查询总条数
	public int totalCount();
	//分页
	public List<Task> findTask(int start,int pageSize);
	//模糊查询
	public List<Task> searchTask(Task task);

}
