package com.pm.service;

import java.util.List;

import com.pm.bean.Customer;

public interface ICustomerService {
	//分页
		public List<Customer> findCustomer(int Start,int pageSize);
		//查询总条数
		public int totalCount();
		//添加
		public void addCustomer(Customer customer);
		//修改前查询id
		public Customer findById(int id);
		//修改
		public void editCustomer(Customer customer);
		//删除
		public void delCustomer(Customer customer);
		//检索
		public List<Customer> search(Customer customer);
}
