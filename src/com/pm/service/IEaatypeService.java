package com.pm.service;

import java.util.List;
import com.pm.bean.EaaType;

public interface IEaatypeService {
	//��ҳ
		public List<EaaType> findEaatype(int Start,int pageSize);
		//��ѯ������
		public int totalCount();
		//���
		public void addEaaType(EaaType eaaType);
		//�޸�ǰ��ѯid
		public EaaType findById(int id);
		//�޸�
		public void editEaaType(EaaType eaaType);
		//ɾ��
		public void delEaaType(EaaType eaaType);
		//����
		public List<EaaType> search(EaaType eaaType);
}
