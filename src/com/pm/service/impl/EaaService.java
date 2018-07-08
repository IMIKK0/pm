package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pm.bean.Eaa;
import com.pm.bean.EaaType;
import com.pm.bean.Emp;
import com.pm.dao.IEaaDao;
import com.pm.service.IEaaService;
@Service
public class EaaService implements IEaaService{
  @Resource
  private IEaaDao ieaadao;
	@Override
	public List<Eaa> findEaa(int Start, int pageSize) {
		// TODO Auto-generated method stub
		return ieaadao.findEaa(Start, pageSize);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return ieaadao.totalCount();
	}

	@Override
	public void addEaa(Eaa eaa) {
		// TODO Auto-generated method stub
		ieaadao.addEaa(eaa);
	}

	@Override
	public Eaa findById(int id) {
		// TODO Auto-generated method stub
		return ieaadao.findById(id);
	}

	@Override
	public void editEaa(Eaa eaa) {
		// TODO Auto-generated method stub
		ieaadao.editEaa(eaa);
	}

	@Override
	public void delEaa(Eaa eaa) {
		// TODO Auto-generated method stub
		ieaadao.delEaa(eaa);
	}

	@Override
	public List<Eaa> search(Eaa eaa) {
		// TODO Auto-generated method stub
		return ieaadao.search(eaa);
	}

	@Override
	public List<EaaType> findEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		return ieaadao.findEaaType(eaaType);
	}

	@Override
	public List<Emp> findEmp(Emp emp) {
		// TODO Auto-generated method stub
		return ieaadao.findEmp(emp);
	}
   
}
