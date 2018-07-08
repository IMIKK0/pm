package com.pm.service;

import java.util.List;

import com.pm.bean.Eaa;
import com.pm.bean.EaaType;
import com.pm.bean.Emp;

public interface IEaaService {
	//分页
		public List<Eaa> findEaa(int Start,int pageSize);
		//查询总条数
		public int totalCount();
		//添加
		public void addEaa(Eaa eaa);
		//修改前查询id
		public Eaa findById(int id);
		//修改
		public void editEaa(Eaa eaa);
		//删除
		public void delEaa(Eaa eaa);
		//检索
		public List<Eaa> search(Eaa eaa);
		//查询部门
		public List<EaaType> findEaaType(EaaType eaaType);
		//查询emp
		public List<Emp> findEmp(Emp emp);
}
