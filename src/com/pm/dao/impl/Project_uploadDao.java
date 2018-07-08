package com.pm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pm.bean.Project_info;
import com.pm.bean.Project_upload;
import com.pm.dao.DaoUtil;

@Repository("project_uploadDao")
public class Project_uploadDao implements DaoUtil<Project_upload> {
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(Project_upload project_upload) {
		hibernateTemplate.save(project_upload);
	}

	@Override
	public void delete(Project_upload project_upload) {
	hibernateTemplate.delete(project_upload);
	}

	@Override
	public Project_upload getById(int id) {
		String hql="from Project_upload where id=?";	
		List<Project_upload> list = (List<Project_upload>) hibernateTemplate.find(hql,id);
		//List<Student> list = hibernateTemplate.findByExample(student);		
		if (!list.isEmpty()) {
			Project_upload project_upload=list.get(0);
			return project_upload;			
		}
		return null;
	}

	@Override
	public void update(Project_upload project_upload) {
		hibernateTemplate.update(project_upload);
	}

	@Override
	public List<Project_upload> findAll(int start, int pageSize) {
		return hibernateTemplate.execute(new HibernateCallback<List<Project_upload>>() {

			@Override
			public List<Project_upload> doInHibernate(Session session) throws HibernateException {
				Query<Project_upload> query = session.createQuery(" from Project_upload");
				query.setFirstResult(start);	
				query.setMaxResults(pageSize);
				System.out.println(0000);
				return query.list();
			}			
		});
	}

	@Override
	public int totalCount() {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(*) from Project_upload");
				Integer totalCount = Integer.parseInt(query.uniqueResult().toString()); 
				return totalCount;
			}			
		});
	}

	@Override
	public List<Project_upload> searchEmp(Project_upload project_upload) {
		// TODO Auto-generated method stub
		return null;
	}

}
