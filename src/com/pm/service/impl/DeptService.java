package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Dept;
import com.pm.dao.DaoUtil;
import com.pm.service.ServiceUtil;
@Service
public class DeptService implements ServiceUtil<Dept> {
	
	@Resource
	private DaoUtil<Dept> deptDao;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void save(Dept dept) {
		deptDao.save(dept);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void delete(Dept dept) {
		deptDao.delete(dept);
	}

	@Override
	public Dept getById(int id) {
		
		return deptDao.getById(id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void update(Dept dept) {
		deptDao.update(dept);
	}

	@Override
	public List<Dept> findAll(int start, int pageSize) {	
		return deptDao.findAll(start, pageSize);
	}

	@Override
	public int totalCount() {
		
		return deptDao.totalCount();
	}

	@Override
	public List<Dept> searchEmp(Dept dept) {
		
		return deptDao.searchEmp(dept);
	}

}
