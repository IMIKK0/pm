package com.pm.service;

import java.util.List;

import com.pm.bean.Project_info;

public interface IProject_infoService {
	//���
	public void addProject_info(Project_info project_info);
	//ɾ��
	public void deleteProject_info(Project_info project_info);
	//�޸�֮ǰ�ò�ѯ
	public Project_info findProject_infoByid(int id);
	//�޸�
	public void updateProject_info(Project_info project_info);
	//��ѯ������
	public int totalCount();
	//��ҳ
	public List<Project_info> findProject_info(int start,int pageSize);
	//ģ����ѯ
	public List<Project_info> searchPro(Project_info project_info);


}
