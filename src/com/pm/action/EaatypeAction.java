package com.pm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pm.bean.EaaType;
import com.pm.service.IEaatypeService;

@Controller
public class EaatypeAction {
 @Resource
 private IEaatypeService ieEaatypeService;
 private EaaType eaaType;
 private List<EaaType> eaaList;
 private List<EaaType> searchList;
 private int totalCount;
 private int totalPage;
 private int currentPage=1;
 private int pageSize=3;
 
 //分页
 public String findEaatype(){
	 int Start=(currentPage-1)*pageSize;
	 eaaList= ieEaatypeService.findEaatype(Start, pageSize);
	 totalCount=ieEaatypeService.totalCount();
	 totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	 return "findEaatype";
 } 
 //跳转添加
 public String toAdd(){
	 return "toAdd";
 }
 //添加
 public String addEaatype(){
	ieEaatypeService.addEaaType(eaaType);
	return "addEaatype";
 }
 //修改前查询
 public String findById(){
	 eaaType = ieEaatypeService.findById(eaaType.getId());
	 return "findById";
 }
 //修改
 public String editEaatype(){
	 ieEaatypeService.editEaaType(eaaType);
	 return "editEaatype";
 }
 //删除
 public String delEaatype(){
	 ieEaatypeService.delEaaType(eaaType);
	 return "delEaatype";
 }
 //检索
 public String search(){
	searchList =  ieEaatypeService.search(eaaType);
	 return "search";
}
 
public EaaType getEaaType() {
	return eaaType;
}
public void setEaaType(EaaType eaaType) {
	this.eaaType = eaaType;
}
public List<EaaType> getEaaList() {
	return eaaList;
}
public void setEaaList(List<EaaType> eaaList) {
	this.eaaList = eaaList;
}
public List<EaaType> getSearchList() {
	return searchList;
}
public void setSearchList(List<EaaType> searchList) {
	this.searchList = searchList;
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
 
 
}
