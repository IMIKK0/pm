package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pm.bean.Customer;
import com.pm.dao.ICustomerDao;
import com.pm.dao.impl.CustomerDao;
import com.pm.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService{
    @Resource
    private ICustomerDao customerDao;
	@Override
	public List<Customer> findCustomer(int Start, int pageSize) {
		// TODO Auto-generated method stub
		return customerDao.findCustomer(Start, pageSize);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return customerDao.totalCount();
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id);
	}

	@Override
	public void editCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.editCustomer(customer);
	}

	@Override
	public void delCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delCustomer(customer);
	}

	@Override
	public List<Customer> search(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.search(customer);
	}

}
