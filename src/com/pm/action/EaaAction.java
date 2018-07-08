package com.pm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pm.bean.Eaa;
import com.pm.bean.EaaType;
import com.pm.bean.Emp;
import com.pm.service.IEaaService;

@Controller
public class EaaAction {
@Resource
private IEaaService eaaService;
private Eaa eaa;
private EaaType eaaType;
private int currentPage=1;
private int pageSize=3;
private int totalCount;
private int totalPage;
private List<Eaa> eaaList;
private List<Eaa> searchList;
private List<EaaType> eaaTypeList;
private List<Emp> empList;
private Emp emp; 
//分页
public String findEaa(){
	int Start = (currentPage-1)*pageSize;
	eaaList = eaaService.findEaa(Start, pageSize);
	totalCount=eaaService.totalCount();
	totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	return "findEaa";
}
//跳转添加
public String toAdd(){
	eaaTypeList = eaaService.findEaaType(eaaType);
	empList = eaaService.findEmp(emp);
	return "toAdd";
}
//添加
public String addEaa(){
	eaaService.addEaa(eaa);
	return "addEaa";
}
//修改前查询
public String findById(){
	eaaTypeList = eaaService.findEaaType(eaaType);
	eaa = eaaService.findById(eaa.getId());
	empList = eaaService.findEmp(emp);
	return "findById";
}
//修改
public String editEaa(){
	eaaService.editEaa(eaa);
	return "editEaa";
}
//删除
public String delEaa(){
	eaaService.delEaa(eaa);
	return "delEaa";
}
//检索
public String search(){
	searchList = eaaService.search(eaa);
	return "search";
}

public Emp getEmp() {
	return emp;
}
public void setEmp(Emp emp) {
	this.emp = emp;
}
public List<Emp> getEmpList() {
	return empList;
}
public void setEmpList(List<Emp> empList) {
	this.empList = empList;
}
public Eaa getEaa() {
	return eaa;
}
public void setEaa(Eaa eaa) {
	this.eaa = eaa;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public List<Eaa> getEaaList() {
	return eaaList;
}
public void setEaaList(List<Eaa> eaaList) {
	this.eaaList = eaaList;
}
public List<Eaa> getSearchList() {
	return searchList;
}
public void setSearchList(List<Eaa> searchList) {
	this.searchList = searchList;
}
public EaaType getEaaType() {
	return eaaType;
}
public void setEaaType(EaaType eaaType) {
	this.eaaType = eaaType;
}
public List<EaaType> getEaaTypeList() {
	return eaaTypeList;
}
public void setEaaTypeList(List<EaaType> eaaTypeList) {
	this.eaaTypeList = eaaTypeList;
}


}
