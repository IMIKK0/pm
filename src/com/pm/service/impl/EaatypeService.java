package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pm.bean.EaaType;
import com.pm.dao.IEaatypeDao;
import com.pm.service.IEaatypeService;
@Service
public class EaatypeService implements IEaatypeService{
   @Resource
   private IEaatypeDao IeaatypeDao;
	@Override
	public List<EaaType> findEaatype(int Start, int pageSize) {
		// TODO Auto-generated method stub
		return IeaatypeDao.findEaatype(Start, pageSize);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return IeaatypeDao.totalCount();
	}

	@Override
	public void addEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		IeaatypeDao.addEaaType(eaaType);
	}

	@Override
	public EaaType findById(int id) {
		// TODO Auto-generated method stub
		return IeaatypeDao.findById(id);
	}

	@Override
	public void editEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		IeaatypeDao.editEaaType(eaaType);
	}

	@Override
	public void delEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		IeaatypeDao.delEaaType(eaaType);
	}

	@Override
	public List<EaaType> search(EaaType eaaType) {
		// TODO Auto-generated method stub
		return IeaatypeDao.search(eaaType);
	}

}
