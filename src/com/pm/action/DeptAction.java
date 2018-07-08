package com.pm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pm.bean.Dept;
import com.pm.service.ServiceUtil;
import com.pm.util.PageUtiles;
import com.sun.xml.internal.bind.v2.model.core.ID;

@Controller
public class DeptAction {
	@Resource
	private ServiceUtil<Dept> deptService;
	private Dept dept;
	private List<Dept> listDept;
	private PageUtiles page;
	private String num;
	public String add(){
		return "add";
	}
	public String save(){
		deptService.save(dept);
		return "save";		
	}
	public String delete(){
		deptService.delete(dept);
		return "delete";
	}
	public String getByid(){
		dept = deptService.getById(dept.getD_id());
		return "getByid";
	}
	public String update(){
		deptService.update(dept);
		return "update";
	}
	public String findAll(){
		int pageNum = 1;
		if(num!=null){
			pageNum = Integer.parseInt(num);
		}
		//×ÜÌõÊý
		int totalRecordsNumber = deptService.totalCount();
		page= new PageUtiles(pageNum, totalRecordsNumber); 
		listDept = deptService.findAll(page.getStartIndex(), page.getPageSize());		
		
		return "findAll";
	}
	public String searchDept(){
		listDept = deptService.searchEmp(dept);
		return "searchDept";
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<Dept> getListDept() {
		return listDept;
	}
	public void setListDept(List<Dept> listDept) {
		this.listDept = listDept;
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
	
	
}
