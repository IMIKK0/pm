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

import com.pm.bean.Customer;
import com.pm.dao.ICustomerDao;

@Repository
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class CustomerDao implements ICustomerDao{
    @Resource
    private HibernateTemplate hibernateTemplate;
	@Override
	public List<Customer> findCustomer(int Start, int pageSize) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<Customer>>() {

			@Override
			public List<Customer> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query=session.createQuery("from Customer");
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
				Query query=session.createQuery("select count(*) from Customer");
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(customer);
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Customer.class, id);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void editCustomer(Customer customer) {
		hibernateTemplate.update(customer);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void delCustomer(Customer customer) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(customer);
	}

	@Override
	public List<Customer> search(Customer customer) {
		// TODO Auto-generated method stub
		String hql="from Customer where 1=1";
		if(customer!=null && customer.getCompany()!=null && !"".equals(customer.getCompany().trim())){
			hql+=" and company like '%"+customer.getCompany()+"%'";
		}
		return (List<Customer>) hibernateTemplate.find(hql);
	}


}
