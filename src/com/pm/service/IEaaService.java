package com.pm.service;

import java.util.List;

import com.pm.bean.Eaa;
import com.pm.bean.EaaType;
import com.pm.bean.Emp;

public interface IEaaService {
	//��ҳ
		public List<Eaa> findEaa(int Start,int pageSize);
		//��ѯ������
		public int totalCount();
		//���
		public void addEaa(Eaa eaa);
		//�޸�ǰ��ѯid
		public Eaa findById(int id);
		//�޸�
		public void editEaa(Eaa eaa);
		//ɾ��
		public void delEaa(Eaa eaa);
		//����
		public List<Eaa> search(Eaa eaa);
		//��ѯ����
		public List<EaaType> findEaaType(EaaType eaaType);
		//��ѯemp
		public List<Emp> findEmp(Emp emp);
}
