package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Project_upload;
import com.pm.dao.DaoUtil;
import com.pm.service.ServiceUtil;
@Service("project_uploadService")
public class Project_uploadService implements ServiceUtil<Project_upload> {
	@Resource
	private DaoUtil<Project_upload>  project_uploadDao; 

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void save(Project_upload project_upload) {
		project_uploadDao.save(project_upload);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void delete(Project_upload project_upload) {
		project_uploadDao.delete(project_upload);
	}

	@Override
	public Project_upload getById(int id) {
		
		return project_uploadDao.getById(id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void update(Project_upload project_upload) {
		project_uploadDao.update(project_upload);
	}

	@Override
	public List<Project_upload> findAll(int start, int pageSize) {
		
		return project_uploadDao.findAll(start, pageSize);
	}

	@Override
	public int totalCount() {
		
		return project_uploadDao.totalCount();
	}

	@Override
	public List<Project_upload> searchEmp(Project_upload project_upload) {
		
		return project_uploadDao.searchEmp(project_upload);
	}

}
