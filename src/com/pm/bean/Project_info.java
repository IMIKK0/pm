package com.pm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_info")
public class Project_info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_id;
	private String p_name;//项目名称
	private String p_budget;//项目预算
	private String p_createtime;//创建时间
	private int task_id;//优先级
	private String p_flag;//完成状态
	private String p_endtime;//完成时间
	private String p_remarks;//备注
	@ManyToOne//员工负责人
	@JoinColumn(name="emp_id")
	private Emp emp;
	@OneToOne
	@JoinColumn(name="customer_id")  
	private Customer customer;//客户名称
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_budget() {
		return p_budget;
	}
	public void setP_budget(String p_budget) {
		this.p_budget = p_budget;
	}
	public String getP_createtime() {
		return p_createtime;
	}
	public void setP_createtime(String p_createtime) {
		this.p_createtime = p_createtime;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	
	public String getP_flag() {
		return p_flag;
	}
	public void setP_flag(String p_flag) {
		this.p_flag = p_flag;
	}
	public String getP_endtime() {
		return p_endtime;
	}
	public void setP_endtime(String p_endtime) {
		this.p_endtime = p_endtime;
	}
	public String getP_remarks() {
		return p_remarks;
	}
	public void setP_remarks(String p_remarks) {
		this.p_remarks = p_remarks;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
