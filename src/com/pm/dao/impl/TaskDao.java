package com.pm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.pm.bean.Task;
import com.pm.dao.ITaskDao;

@Repository("taskDao")
public class TaskDao implements ITaskDao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	//���
	@Override
	public void addTask(Task task) {
		hibernateTemplate.save(task);		
	}
	//ɾ��
	@Override
	public void deleteTask(Task task) {
		String hql = "delete from Task where id=?";
		task.setT_id(task.getT_id());
		hibernateTemplate.delete(task);			
	}
	//����֮ǰ�ò�ѯ
	@Override
	public Task findTaskByid(int id) {
		String hql="from Task where id=?";	
		List<Task> list = (List<Task>) hibernateTemplate.find(hql,id);
		//List<Student> list = hibernateTemplate.findByExample(student);		
		if (!list.isEmpty()) {
			Task task=list.get(0);
			return task;			
		}
		return null;
	}
	//����
	@Override
	public void updateTask(Task task) {
		hibernateTemplate.update(task);
		
	}
	//��ѯ������
	@Override
	public int totalCount() {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(*) from Task");
				Integer totalCount = Integer.parseInt(query.uniqueResult().toString()); 
				return totalCount;
			}			
		});
	}
	//���з�ҳ
	@Override
	public List<Task> findTask(int start, int pageSize) {
		return hibernateTemplate.execute(new HibernateCallback<List<Task>>() {

			@Override
			public List<Task> doInHibernate(Session session) throws HibernateException {
				Query<Task> query = session.createQuery(" from Task");
				query.setFirstResult(start);	
				query.setMaxResults(pageSize);
				return query.list();
			}			
		});
	}
	//ģ����ѯ
	@Override
	public List<Task> searchTask(Task task) {
		String hql = "from Task where 1=1 ";	
		if(task!=null && task.getT_title()!=null && !"".equals(task.getT_title().trim())){
			hql+=" and t_title like '%"+task.getT_title()+"%'";
		}
		List<Task> listTask = (List<Task>) hibernateTemplate.find(hql);	
		
		return listTask;
	}
}
