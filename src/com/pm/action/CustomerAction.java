package com.pm.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pm.bean.Customer;
import com.pm.service.ICustomerService;

@Controller
public class CustomerAction {
	   @Resource
	   private ICustomerService customerService;
	   private Customer customer;
	   private int currentPage=1;
	   private int pageSize=3;
	   private int totalCount;
	   private int totalPage;
	   private List<Customer> custList=new ArrayList<>();
	   private List<Customer> searchList=new ArrayList<>();
	   
	   //分页
	   public String findCustomer(){
		   int Start=(currentPage-1)*pageSize;
		   custList=customerService.findCustomer(Start, pageSize);
		   totalCount=customerService.totalCount();
		   totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		   return "findCustomer";
	   }
	   //跳转
	   public String toAdd(){
		   return "toAdd";
	   }
     //添加
	   public String addCustomer(){
		   customerService.addCustomer(customer);
		   return "addCustomer";
	   }
	   //修改前查询id
	   public String findById(){
		   customer=customerService.findById(customer.getC_id());
		   return "findById";
	   }
	   //修改
	   public String editCustomer(){
		   System.out.println(customer.getC_id());
		   customerService.editCustomer(customer);
		   return "editCustomer";
	   }
	   //删除
	   public String delCustomer(){
			  customerService.delCustomer(customer);
		   return "delCustomer";
	   }
	   //检索
	   public String search(){
		  searchList= customerService.search(customer);
		   return "search";
	   }
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public List<Customer> getCustList() {
		return custList;
	}

	public void setCustList(List<Customer> custList) {
		this.custList = custList;
	}

	public List<Customer> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<Customer> searchList) {
		this.searchList = searchList;
	}
	
}
