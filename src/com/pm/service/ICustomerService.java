package com.pm.service;

import java.util.List;

import com.pm.bean.Customer;

public interface ICustomerService {
	//��ҳ
		public List<Customer> findCustomer(int Start,int pageSize);
		//��ѯ������
		public int totalCount();
		//���
		public void addCustomer(Customer customer);
		//�޸�ǰ��ѯid
		public Customer findById(int id);
		//�޸�
		public void editCustomer(Customer customer);
		//ɾ��
		public void delCustomer(Customer customer);
		//����
		public List<Customer> search(Customer customer);
}
