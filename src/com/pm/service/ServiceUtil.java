package com.pm.service;

import java.util.List;

public interface ServiceUtil<T> {
		//���
		void save(T entity);
		//ɾ��
		void delete(T entity);
		//�޸�֮ǰ�Ĳ�ѯ
		T getById(int id);
		//�޸�
		void update(T entity);
		//��ѯ����
		List<T> findAll(int start,int pageSize);
		//��ѯ������
		 int totalCount();
		 //ģ������
		 List<T> searchEmp(T entity);
}
