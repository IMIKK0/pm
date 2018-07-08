package com.pm.util;

import java.io.Serializable;
import java.util.List;

public class PageUtiles implements Serializable {
	private List records;//分页记录
	private int pageSize=2;// 每页显示的条数
	private int pageNum;//当前页码
	private int startIndex;//每页开始记录的索引
	private int totalRecordsNumber;//总记录条数
	private int totalPageNumber;//总页数	
	private int nextPageNum;//下一页的页码
	private int prePageNum;//上一页的页码
	
	
	public PageUtiles(int pageNum,int totalRecordsNumber){
		this.pageNum = pageNum;
		this.totalRecordsNumber = totalRecordsNumber;
		//计算开始索引
		startIndex = (pageNum-1)*pageSize;
		//计算总页数
		totalPageNumber = totalRecordsNumber%pageSize==0?totalRecordsNumber/pageSize:totalRecordsNumber/pageSize+1;
		//计算下一页的页码
		nextPageNum = pageNum+1>totalPageNumber?totalPageNumber:pageNum+1;
		//计算上一页
		prePageNum = pageNum-1<1?1:pageNum-1;
	}
	
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalRecordsNumber() {
		return totalRecordsNumber;
	}
	public void setTotalRecordsNumber(int totalRecordsNumber) {
		this.totalRecordsNumber = totalRecordsNumber;
	}
	public int getTotalPageNumber() {
		return totalPageNumber;
	}
	public void setTotalPageNumber(int totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}	
}