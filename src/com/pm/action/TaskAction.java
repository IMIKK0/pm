package com.pm.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;

import com.pm.bean.Emp;
import com.pm.bean.Task;
import com.pm.service.IInformationService;
import com.pm.service.ITaskService;
import com.pm.util.PageUtiles;


@Controller
public class TaskAction {
	private Task task ;
	private PageUtiles page;
	private String num;
	private List<Task> listTask;
	@Resource
	private ITaskService taskService;
	@Resource
	private IInformationService informationService;
	private List<Emp> listEmpName;
	private List<Emp> emp;
/*	private Jurisdiction jurisdiction;*/
	public String findEmpName(){
		listEmpName = informationService.findEmpName();	
		return "findEmpName";
	}
	
	//���
	public String addTask(){
	/*	int id = 1;
		Emp emp = jurisdiction.findEmpName(id);
		if (emp.getJurisdiction() != null) {
			
		}*/
		Set<Emp> emps=new HashSet<>(emp);
		task.setEmps(emps);
		taskService.addTask(task);
		return "addtasksuccess";
	}
	//ɾ��
	public String deleteTask(){
		taskService.deleteTask(task);
		return "deletetasksuccess";		
	}
	//�޸�֮ǰ�ò�ѯ
	public String findTaskByid(){
		listEmpName = informationService.findEmpName();	
		task = taskService.findTaskByid(task.getT_id());
		return "findTaskByid";		
	}
	//�޸�
	public String updateTask(){
		taskService.updateTask(task);
		return "updateTask";		
	}
	//��ҳ
	public String findTask(){
		System.out.println(00);
		int pageNum = 1;
		if(num!=null){
			pageNum = Integer.parseInt(num);
		}
		//������
		int totalRecordsNumber = taskService.totalCount();
		page= new PageUtiles(pageNum, totalRecordsNumber); 
		listTask = taskService.findTask(page.getStartIndex(), page.getPageSize());
		//count = page.getTotalPageNumber();		
		return "findTask";
		
	}
	//ģ����ѯ
	public String searchTask(){
		System.out.println(task.getT_title());
		listTask = taskService.searchTask(task);		
		return "searchTask";	
	}

	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public PageUtiles getPage() {
		return page;
	}
	public void setPage(PageUtiles page) {
		this.page = page;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<Task> getListTask() {
		return listTask;
	}
	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}

	public List<Emp> getListEmpName() {
		return listEmpName;
	}

	public void setListEmpName(List<Emp> listEmpName) {
		this.listEmpName = listEmpName;
	}

	public List<Emp> getEmp() {
		return emp;
	}

	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}

	
}
