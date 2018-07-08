package com.pm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pm.bean.Dept;
import com.pm.bean.Emp;
import com.pm.dao.DaoUtil;
@Repository("deptDao")
public class DeptDao implements DaoUtil<Dept> {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(Dept dept) {
		hibernateTemplate.save(dept);
	}

	@Override
	public void delete(Dept dept) {
	hibernateTemplate.delete(dept);
	}

	@Override
	public Dept getById(int id) {
		String hql="from Dept where id=?";	
		List<Dept> list = (List<Dept>) hibernateTemplate.find(hql,id);		
		if (!list.isEmpty()) {
			Dept dept=list.get(0);
			return dept;			
		}
		return null;
	}

	@Override
	public void update(Dept dept) {
		hibernateTemplate.update(dept);
		
	}

	@Override
	public List<Dept> findAll(int start, int pageSize) {
		return hibernateTemplate.execute(new HibernateCallback<List<Dept>>() {

			@Override
			public List<Dept> doInHibernate(Session session) throws HibernateException {
				Query<Dept> query = session.createQuery(" from Dept");
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
				Query query = session.createQuery("select count(*) from Dept");
				Integer totalCount = Integer.parseInt(query.uniqueResult().toString()); 
				return totalCount;
			}			
		});
	}

	@Override
	public List<Dept> searchEmp(Dept dept) {
		// TODO Auto-generated method stub
		return null;
	}

}
