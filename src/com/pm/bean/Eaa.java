package com.pm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="eaa")
public class Eaa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String eaa_name;
  @ManyToOne
  @JoinColumn(name="eaa_id")
  private EaaType eaaType;
  @ManyToOne
  @JoinColumn(name="emp_id")
  private Emp emp;
  private String eaa_content;
  private String eaa_state;
  private String eaa_time;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getEaa_name() {
	return eaa_name;
}
public void setEaa_name(String eaa_name) {
	this.eaa_name = eaa_name;
}
public EaaType getEaaType() {
	return eaaType;
}
public void setEaaType(EaaType eaaType) {
	this.eaaType = eaaType;
}

public Emp getEmp() {
	return emp;
}
public void setEmp(Emp emp) {
	this.emp = emp;
}
public String getEaa_content() {
	return eaa_content;
}
public void setEaa_content(String eaa_content) {
	this.eaa_content = eaa_content;
}
public String getEaa_state() {
	return eaa_state;
}
public void setEaa_state(String eaa_state) {
	this.eaa_state = eaa_state;
}
public String getEaa_time() {
	return eaa_time;
}
public void setEaa_time(String eaa_time) {
	this.eaa_time = eaa_time;
}
  
  
}
