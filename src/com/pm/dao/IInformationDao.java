package com.pm.dao;

import java.util.List;

import com.pm.bean.Emp;
import com.pm.bean.Information;


public interface IInformationDao {
		//���
		public void addinformation(Information information);
		//ɾ��
		public void deleteinformation(Information information);
		//�޸�֮ǰ�ò�ѯ
		public Information findinformationByid(int id);
		//�޸�
		public void updateinformation(Information information);
		//��ѯ������
		public int totalCount();
		//��ҳ
		public List<Information> findinformation(int start,int pageSize);
		//ģ����ѯ
		public List<Information> searchinformation(Information information);
		//��ѯ��������
		public List<Emp> findEmpName();
}
