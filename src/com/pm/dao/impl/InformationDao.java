package com.pm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pm.bean.Emp;
import com.pm.bean.Information;
import com.pm.bean.Task;
import com.pm.dao.IInformationDao;

@Repository("informationDao")
public class InformationDao implements IInformationDao {
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void addinformation(Information information) {
		hibernateTemplate.save(information);
		
	}

	@Override
	public void deleteinformation(Information information) {
		hibernateTemplate.delete(information);
		
	}

	@Override
	public Information findinformationByid(int id) {
		String hql="from Information where id=?";	
		List<Information> list = (List<Information>) hibernateTemplate.find(hql,id);
		//List<Student> list = hibernateTemplate.findByExample(student);		
		if (!list.isEmpty()) {
			Information information=list.get(0);
			return information;			
		}
		return null;
	}

	@Override
	public void updateinformation(Information information) {
		hibernateTemplate.update(information);
	}

	@Override
	public int totalCount() {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(*) from Information");
				Integer totalCount = Integer.parseInt(query.uniqueResult().toString()); 
				return totalCount;
			}			
		});
	}

	@Override
	public List<Information> findinformation(int start, int pageSize) {
		return hibernateTemplate.execute(new HibernateCallback<List<Information>>() {

			@Override
			public List<Information> doInHibernate(Session session) throws HibernateException {
				Query<Information> query = session.createQuery(" from Information");
				query.setFirstResult(start);	
				query.setMaxResults(pageSize);
				return query.list();
			}			
		});
	}

	@Override
	public List<Information> searchinformation(Information information) {
		String hql = "from Information where 1=1 ";	
		if(information!=null && information.getL_name()!=null && !"".equals(information.getL_name().trim())){
			hql+=" and t_title like '%"+information.getL_name()+"%'";
		}
		List<Information> listinformation = (List<Information>) hibernateTemplate.find(hql);			
		return listinformation;
	}
	//查询Emp表中的名
	@Override
	public List<Emp> findEmpName() {
		return hibernateTemplate.execute(new HibernateCallback<List<Emp>>() {
			@Override
			public List<Emp> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return session.createQuery("from Emp").list();
			}
		});
	}
}
