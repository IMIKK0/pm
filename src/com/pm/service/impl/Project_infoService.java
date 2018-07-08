package com.pm.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Project_info;
import com.pm.dao.IProject_infoDao;
import com.pm.service.IProject_infoService;

@Service("infoService")
public class Project_infoService implements IProject_infoService {
	@Resource(name="project_infoDao")
	private IProject_infoDao project_infoDao;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void addProject_info(Project_info project_info) {
		project_infoDao.addProject_info(project_info);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void deleteProject_info(Project_info project_info) {
		project_infoDao.deleteProject_info(project_info);
	}

	@Override
	public Project_info findProject_infoByid(int id) {		
		return project_infoDao.findProject_infoByid(id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void updateProject_info(Project_info project_info) {
		project_infoDao.updateProject_info(project_info);
	}

	@Override
	public int totalCount() {		
		return project_infoDao.totalCount();
	}

	@Override
	public List<Project_info> findProject_info(int start, int pageSize) {	
		return project_infoDao.findProject_info(start, pageSize);
	}

	@Override
	public List<Project_info> searchPro(Project_info project_info) {		
		return project_infoDao.searchPro(project_info);
	}

}
