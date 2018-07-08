package com.pm.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="information")
public class Information {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer l_id;
	private String l_name;//信息标题
	private String l_content;//消息内容
	private String l_state;//读取状态
	private String l_time=new SimpleDateFormat("yyyy/MM/dd").format(new Date());//发送日期
	@ManyToOne//接收人
	@JoinColumn(name="emp_id")
	private Emp emp;
	public Integer getL_id() {
		return l_id;
	}
	public void setL_id(Integer l_id) {
		this.l_id = l_id;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_content() {
		return l_content;
	}
	public void setL_content(String l_content) {
		this.l_content = l_content;
	}
	public String getL_state() {
		return l_state;
	}
	public void setL_state(String l_state) {
		this.l_state = l_state;
	}
	public String getL_time() {
		return l_time;
	}
	public void setL_time(String l_time) {
		this.l_time = l_time;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
