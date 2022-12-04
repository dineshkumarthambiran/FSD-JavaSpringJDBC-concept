package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private Integer eid;
	private String eName;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer eid, String eName) {
		super();
		this.eid = eid;
		this.eName = eName;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
}
