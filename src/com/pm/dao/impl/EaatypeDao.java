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

import com.pm.bean.EaaType;
import com.pm.dao.IEaatypeDao;
@Repository
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class EaatypeDao implements IEaatypeDao{
    @Resource
    private HibernateTemplate hibernateTemplate;
	@Override
	public List<EaaType> findEaatype(int Start, int pageSize) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<EaaType>>() {

			@Override
			public List<EaaType> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from EaaType");
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
				Query query=session.createQuery("select count(*) from EaaType");
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public void addEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(eaaType);
	}

	@Override
	public EaaType findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(EaaType.class, id);
	}

	@Override
	public void editEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(eaaType);
	}

	@Override
	public void delEaaType(EaaType eaaType) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(eaaType);
	}

	@Override
	public List<EaaType> search(EaaType eaaType) {
		// TODO Auto-generated method stub
		String hql="from EaaType where 1=1";
		if(eaaType!=null && eaaType.getEaa_name()!=null && !"".equals(eaaType.getEaa_name().trim())){
			hql+=" and eaa_name like '%"+eaaType.getEaa_name()+"%'";
		}
		return null;
	}

}
