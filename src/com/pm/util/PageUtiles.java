package com.pm.util;

import java.io.Serializable;
import java.util.List;

public class PageUtiles implements Serializable {
	private List records;//��ҳ��¼
	private int pageSize=2;// ÿҳ��ʾ������
	private int pageNum;//��ǰҳ��
	private int startIndex;//ÿҳ��ʼ��¼������
	private int totalRecordsNumber;//�ܼ�¼����
	private int totalPageNumber;//��ҳ��	
	private int nextPageNum;//��һҳ��ҳ��
	private int prePageNum;//��һҳ��ҳ��
	
	
	public PageUtiles(int pageNum,int totalRecordsNumber){
		this.pageNum = pageNum;
		this.totalRecordsNumber = totalRecordsNumber;
		//���㿪ʼ����
		startIndex = (pageNum-1)*pageSize;
		//������ҳ��
		totalPageNumber = totalRecordsNumber%pageSize==0?totalRecordsNumber/pageSize:totalRecordsNumber/pageSize+1;
		//������һҳ��ҳ��
		nextPageNum = pageNum+1>totalPageNumber?totalPageNumber:pageNum+1;
		//������һҳ
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