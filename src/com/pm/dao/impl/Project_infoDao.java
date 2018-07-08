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
import com.pm.bean.Project_info;
import com.pm.dao.IProject_infoDao;

@Repository("project_infoDao")
public class Project_infoDao implements IProject_infoDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addProject_info(Project_info project_info) {
		hibernateTemplate.save(project_info);
	}

	@Override
	public void deleteProject_info(Project_info project_info) {
		hibernateTemplate.delete(project_info);
	}

	@Override
	public Project_info findProject_infoByid(int id) {
		String hql="from Project_info where id=?";	
		List<Project_info> list = (List<Project_info>) hibernateTemplate.find(hql,id);
		//List<Student> list = hibernateTemplate.findByExample(student);		
		if (!list.isEmpty()) {
			Project_info project_info=list.get(0);
			return project_info;			
		}
		return null;
	}

	@Override
	public void updateProject_info(Project_info project_info) {
		hibernateTemplate.update(project_info);
	}

	@Override
	public int totalCount() {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(*) from Project_info");
				Integer totalCount = Integer.parseInt(query.uniqueResult().toString()); 
				return totalCount;
			}			
		});
	}

	@Override
	public List<Project_info> findProject_info(int start, int pageSize) {
		return hibernateTemplate.execute(new HibernateCallback<List<Project_info>>() {

			@Override
			public List<Project_info> doInHibernate(Session session) throws HibernateException {
				Query<Project_info> query = session.createQuery(" from Project_info");
				query.setFirstResult(start);	
				query.setMaxResults(pageSize);
				System.out.println(0000);
				return query.list();
			}			
		});
	}
	@Override
	public List<Project_info> searchPro(Project_info project_info) {
		String hql = "from Project_info where 1=1 ";	
		if(project_info!=null && project_info.getP_name()!=null && !"".equals(project_info.getP_name().trim())){
			hql+=" and p_name like '%"+project_info.getP_name()+"%'";
		}
		List<Project_info> listProject_info = (List<Project_info>) hibernateTemplate.find(hql);			
		return listProject_info;
	}
}
