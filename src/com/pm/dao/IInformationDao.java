package com.pm.dao;

import java.util.List;

import com.pm.bean.Emp;
import com.pm.bean.Information;


public interface IInformationDao {
		//添加
		public void addinformation(Information information);
		//删除
		public void deleteinformation(Information information);
		//修改之前得查询
		public Information findinformationByid(int id);
		//修改
		public void updateinformation(Information information);
		//查询总条数
		public int totalCount();
		//分页
		public List<Information> findinformation(int start,int pageSize);
		//模糊查询
		public List<Information> searchinformation(Information information);
		//查询所有姓名
		public List<Emp> findEmpName();
}
