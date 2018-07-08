package com.pm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pm.bean.Emp;
import com.pm.dao.DaoUtil;
import com.pm.dao.IEmpDao;
@Repository("empDao")
public class EmpDao implements IEmpDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Emp emp) {
		hibernateTemplate.save(emp);
	}

	@Override
	public void delete(Emp emp) {
	hibernateTemplate.delete(emp);		
	}

	@Override
	public Emp getById(int id) {
		String hql="from Emp where id=?";	
		List<Emp> list = (List<Emp>) hibernateTemplate.find(hql,id);		
		if (!list.isEmpty()) {
			Emp emp=list.get(0);
			return emp;			
		}
		return null;
	}

	@Override
	public void update(Emp emp) {
		hibernateTemplate.update(emp);		
	}

	@Override
	public List<Emp> findAll(int start, int pageSize) {
		return hibernateTemplate.execute(new HibernateCallback<List<Emp>>() {

			@Override
			public List<Emp> doInHibernate(Session session) throws HibernateException {
				Query<Emp> query = session.createQuery(" from Emp");
				query.setFirstResult(start);	
				query.setMaxResults(pageSize);
				return query.list();
			}			
		});
	}

	@Override
	public int totalCount() {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(*) from Emp");
				Integer totalCount = Integer.parseInt(query.uniqueResult().toString()); 
				return totalCount;
			}			
		});
	}

	@Override
	public List<Emp> searchEmp(Emp emp) {
		String hql = "from Emp where 1=1 ";	
		if(emp!=null && emp.getE_name()!=null && !"".equals(emp.getE_name().trim())){
			hql+=" and e_name like '%"+emp.getE_name()+"%'";
		}
		List<Emp> listEmp = (List<Emp>) hibernateTemplate.find(hql);	
		
		return listEmp;
	}
	//登陆方法
	@Override
	public Emp login(String username, String password) {
		String hql="from Emp where username=? and password=?";
		List<Emp> list = (List<Emp>) hibernateTemplate.find(hql, username,password);
		if (!list.isEmpty()) {
			return list.get(0);//取出集合中第一个元素
		}
		return null;
	}
}
