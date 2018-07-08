package com.pm.service;

import java.util.List;

import com.pm.bean.Task;

public interface ITaskService {
	//���
	public void addTask(Task task);
	//ɾ��
	public void deleteTask(Task task);
	//�޸�֮ǰ�ò�ѯ
	public Task findTaskByid(int id);
	//�޸�
	public void updateTask(Task task);
	//��ѯ������
	public int totalCount();
	//��ҳ
	public List<Task> findTask(int start,int pageSize);
	//ģ����ѯ
	public List<Task> searchTask(Task task);
	

}
