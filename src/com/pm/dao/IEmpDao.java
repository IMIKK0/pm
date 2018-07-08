package com.pm.dao;

import java.util.List;

import com.pm.bean.Emp;

public interface IEmpDao {
	Emp login(String username,String password);
	void save(Emp emp);
	void delete(Emp emp);
	Emp getById(int id);
	void update(Emp emp);
	List<Emp> findAll(int start, int pageSize);
	int totalCount();
	 List<Emp> searchEmp(Emp emp);
	 

}
