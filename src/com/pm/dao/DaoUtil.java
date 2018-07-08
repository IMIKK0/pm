package com.pm.dao;

import java.util.List;

import com.pm.bean.Emp;

public interface DaoUtil<T> {
	//添加
	void save(T entity);
	//删除
	void delete(T entity);
	//修改之前的查询
	T getById(int id);
	//修改
	void update(T entity);
	//查询所有
	List<T> findAll(int start,int pageSize);
	//查询总条数
	 int totalCount();
	 //模糊查找
	 List<T> searchEmp(T entity);

}
