package com.pm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pm.bean.Emp;
import com.pm.bean.Information;
import com.pm.service.IInformationService;
import com.pm.util.PageUtiles;

@Controller
public class InformationAction {
	@Resource
	private IInformationService informationService;
	private Information information;
	private PageUtiles page;
	private String num;
	private List<Information> listinformation;
	private List<Emp> listEmpName;
	private String[] checkid;
	//添加
		public String addInformation(){
			
			informationService.addinformation(information);			
			return "addInformationsuccess";
		}
		//删除
		public String deleteInformation(){
			for (int i = 0; i < checkid.length; i++) {
				information = informationService.findinformationByid(Integer.parseInt(checkid[i]));
				informationService.deleteinformation(information);
			}			
			return "deleteInformationsuccess";		
		}
		//修改之前得查询
		public String findInformationByid(){	
			information = informationService.findinformationByid(information.getL_id());			
			listEmpName = informationService.findEmpName();
			return "findTaskByid";		
		}
		//修改
		public String updateInformation(){
			informationService.updateinformation(information);
			return "updateInformation";		
		}
		//分页
		public String findInformation(){
			int pageNum = 1;
			if(num!=null){
				pageNum = Integer.parseInt(num);
			}
			//总条数
			int totalRecordsNumber = informationService.totalCount();
			page= new PageUtiles(pageNum, totalRecordsNumber); 
			listinformation = informationService.findinformation(page.getStartIndex(), page.getPageSize());
			//count = page.getTotalPageNumber();		
			return "findInformation";
			
		}
		//模糊查询
		public String searchInformation(){
			//System.out.println(task.getT_title());
			listinformation = informationService.searchinformation(information);		
			return "searchInformation";	
		}
		//查询emp中的名字
		public String findEmpName(){			
			listEmpName = informationService.findEmpName();	
			return "findEmpName";
		}
		public Information getInformation() {
			return information;
		}
		public void setInformation(Information information) {
			this.information = information;
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
		public List<Information> getListinformation() {
			return listinformation;
		}
		public void setListinformation(List<Information> listinformation) {
			this.listinformation = listinformation;
		}
		public String[] getCheckid() {
			return checkid;
		}
		public void setCheckid(String[] checkid) {
			this.checkid = checkid;
		}
		public List<Emp> getListEmpName() {
			return listEmpName;
		}
		public void setListEmpName(List<Emp> listEmpName) {
			this.listEmpName = listEmpName;
		}
		
}
