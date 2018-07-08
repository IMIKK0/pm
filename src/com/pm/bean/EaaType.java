package com.pm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eaatype")
public class EaaType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String eaa_name;
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

  
}
