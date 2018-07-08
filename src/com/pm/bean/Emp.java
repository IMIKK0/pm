package com.pm.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int e_id;
	private String e_name;
	private String username;
	private String password;
	private String e_type;//Ա������
	private String id_card;
	private String e_sex;
	private String e_birthday;//��������
	private String e_phone;
	private String e_address;//��ַ
	private String e_mail;//����
	private String e_describe;//����	
	private int jurisdiction;
	@ManyToOne//����
	@JoinColumn(name="dept_id")
	private Dept dept;
/*	@ManyToOne
	@JoinColumn(name="task_id")
	private Task task;*/	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
				name="task_emp",
				joinColumns=@JoinColumn(name="emp_id"),
				inverseJoinColumns=@JoinColumn(name="task_id")
			)
	private Set<Task> tasks = new HashSet<Task>();
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_type() {
		return e_type;
	}
	public void setE_type(String e_type) {
		this.e_type = e_type;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getE_sex() {
		return e_sex;
	}
	public void setE_sex(String e_sex) {
		this.e_sex = e_sex;
	}
	public String getE_birthday() {
		return e_birthday;
	}
	public void setE_birthday(String e_birthday) {
		this.e_birthday = e_birthday;
	}

	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_phone() {
		return e_phone;
	}
	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getE_describe() {
		return e_describe;
	}
	public void setE_describe(String e_describe) {
		this.e_describe = e_describe;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getE_address() {
		return e_address;
	}
	public void setE_address(String e_address) {
		this.e_address = e_address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(int jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}	
}
