package com.pm.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_upload")
public class Project_upload {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int up_id;
	private String up_filename;//ÉÏ´«Ãû³Æ
	private String up_time=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Emp emp;
	@OneToOne
	@JoinColumn(name="info_id")  
	private Project_info project_info;
	public int getUp_id() {
		return up_id;
	}
	public void setUp_id(int up_id) {
		this.up_id = up_id;
	}
	public String getUp_time() {
		return up_time;
	}
	public void setUp_time(String up_time) {
		this.up_time = up_time;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Project_info getProject_info() {
		return project_info;
	}
	public void setProject_info(Project_info project_info) {
		this.project_info = project_info;
	}
	public String getUp_filename() {
		return up_filename;
	}
	public void setUp_filename(String up_filename) {
		this.up_filename = up_filename;
	}
	

}
