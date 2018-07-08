package com.pm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pm.bean.Eaa;
import com.pm.bean.EaaType;
import com.pm.bean.Emp;
import com.pm.dao.IEaaDao;

@Repository
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class EaaDao implements IEaaDao{
  @Resource
  private HibernateTemplate hibernateTemplate;
	@Override
	public List<Eaa> findEaa(int Start, int pageSize) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<Eaa>>() {

			@Override
			public List<Eaa> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from Eaa");
				query.setFirstResult(Start);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("select count(*) from Eaa");
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public void addEaa(Eaa eaa) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(eaa);
	}

	@Override
	public Eaa findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Eaa.class, id);
	}

	@Override
	public void editEaa(Eaa eaa) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(eaa);
	}

	@Override
	public void delEaa(Eaa eaa) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(eaa);
	}

	@Override
	public List<Eaa> search(Eaa eaa) {
		// TODO Auto-generated method stub
		String hql="from Eaa where 1=1";
		if(eaa!=null && eaa.getEaa_name()!=null && !"".equals(eaa.getEaa_name().trim())){
			hql+=" and eaa_name like '%"+eaa.getEaa_name()+"%'";
		}
		return null;
	}

	@Override
	public List<EaaType> findEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<EaaType>>() {

			@Override
			public List<EaaType> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from EaaType");
				return query.list();
			}
		});
	}

	@Override
	public List<Emp> findEmp(Emp emp) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<Emp>>() {

			@Override
			public List<Emp> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from Emp");
				return query.list();
			}
		});
	}

	
}
