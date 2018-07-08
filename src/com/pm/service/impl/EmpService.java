package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Emp;
import com.pm.dao.DaoUtil;
import com.pm.dao.IEmpDao;
import com.pm.service.IEmpService;
import com.pm.service.ServiceUtil;
@Service
public class EmpService implements IEmpService {
	@Resource
	private IEmpDao empDao;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void save(Emp emp) {
		// TODO Auto-generated method stub
		empDao.save(emp);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void delete(Emp emp) {
		empDao.delete(emp);
	}

	@Override
	public Emp getById(int id) {
		return empDao.getById(id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void update(Emp emp) {
		empDao.update(emp);
	}

	@Override
	public List<Emp> findAll(int start, int pageSize) {		
		return empDao.findAll(start, pageSize);
	}

	@Override
	public int totalCount() {		
		return empDao.totalCount();
	}

	@Override
	public List<Emp> searchEmp(Emp emp) {
		return empDao.searchEmp(emp);
	}

	@Override
	public Emp login(String username, String password) {
		
		return empDao.login(username, password);
	}

}
