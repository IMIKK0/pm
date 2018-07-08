package com.pm.service;

import java.util.List;
import com.pm.bean.EaaType;

public interface IEaatypeService {
	//分页
		public List<EaaType> findEaatype(int Start,int pageSize);
		//查询总条数
		public int totalCount();
		//添加
		public void addEaaType(EaaType eaaType);
		//修改前查询id
		public EaaType findById(int id);
		//修改
		public void editEaaType(EaaType eaaType);
		//删除
		public void delEaaType(EaaType eaaType);
		//检索
		public List<EaaType> search(EaaType eaaType);
}
