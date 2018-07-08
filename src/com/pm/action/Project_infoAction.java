package com.pm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pm.bean.Emp;
import com.pm.bean.Project_info;
import com.pm.dao.IProject_infoDao;
import com.pm.service.IInformationService;
import com.pm.service.IProject_infoService;
import com.pm.util.PageUtiles;
import com.sun.xml.internal.ws.developer.StreamingAttachment;

@Controller("project_infoAction")
public class Project_infoAction {
	@Resource(name="infoService")
	private IProject_infoService infoService;
	private Project_info project_info;
	private List<Project_info> listPro;
	private String num;
	private PageUtiles page;
	@Resource
	private IInformationService informationService;
	private List<Emp> listEmpName;
	public String findEmpName(){
		listEmpName = informationService.findEmpName();	
		return "findEmpName";
	}
	//添加
	public String addProject_info(){
		infoService.addProject_info(project_info);
		
		return "addsuccess";	
	}
	//删除
	public String deleteProject_info(){
		infoService.deleteProject_info(project_info);
		return "deletesuccess";
	}
	//修改之前的查询
	public String findProject_infoByid(){
		project_info = infoService.findProject_infoByid(project_info.getP_id());	
		return "findProject_infoByid";
	}
	//修改
	public String updateProject_info(){
		infoService.updateProject_info(project_info);
		return "updatesuccess";		
	}
	//分页
	public String findAll(){
		System.out.println("jahjans");
		int pageNum = 1;
		if(num!=null){
			pageNum = Integer.parseInt(num);
		}
		//总条数
		int totalRecordsNumber = infoService.totalCount();
		page= new PageUtiles(pageNum, totalRecordsNumber);
		listPro = infoService.findProject_info(page.getStartIndex(), page.getPageSize());
		return "findAll";
	}
	//模糊查询
	public String searchPro(){
		listPro = infoService.searchPro(project_info);
		return "searchPro";
	}
	public Project_info getProject_info() {
		return project_info;
	}
	public void setProject_info(Project_info project_info) {
		this.project_info = project_info;
	}
	public List<Project_info> getListPro() {
		return listPro;
	}
	public void setListPro(List<Project_info> listPro) {
		this.listPro = listPro;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public PageUtiles getPage() {
		return page;
	}
	public void setPage(PageUtiles page) {
		this.page = page;
	}
	public List<Emp> getListEmpName() {
		return listEmpName;
	}
	public void setListEmpName(List<Emp> listEmpName) {
		this.listEmpName = listEmpName;
	}
	

}
