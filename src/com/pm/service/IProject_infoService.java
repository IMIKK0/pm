package com.pm.service;

import java.util.List;

import com.pm.bean.Project_info;

public interface IProject_infoService {
	//添加
	public void addProject_info(Project_info project_info);
	//删除
	public void deleteProject_info(Project_info project_info);
	//修改之前得查询
	public Project_info findProject_infoByid(int id);
	//修改
	public void updateProject_info(Project_info project_info);
	//查询总条数
	public int totalCount();
	//分页
	public List<Project_info> findProject_info(int start,int pageSize);
	//模糊查询
	public List<Project_info> searchPro(Project_info project_info);


}
