package com.pm.dao;

import java.util.List;

import com.pm.bean.Emp;

public interface DaoUtil<T> {
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
