package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Emp;
import com.pm.bean.Information;
import com.pm.dao.IInformationDao;
import com.pm.service.IInformationService;

@Service
public class InformationService implements IInformationService {
	@Resource
	private IInformationDao informationDao;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void addinformation(Information information) {
		informationDao.addinformation(information);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void deleteinformation(Information information) {
		informationDao.deleteinformation(information);
		
	}

	@Override
	public Information findinformationByid(int id) {	
		return informationDao.findinformationByid(id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void updateinformation(Information information) {
		informationDao.updateinformation(information);
	}

	@Override
	public int totalCount() {		
		return informationDao.totalCount();
	}

	@Override
	public List<Information> findinformation(int start, int pageSize) {		
		return informationDao.findinformation(start, pageSize);
	}

	@Override
	public List<Information> searchinformation(Information information) {	
		return informationDao.searchinformation(information);
	}
	@Override
	public List<Emp> findEmpName() {
		
		return informationDao.findEmpName();
	}

}
