package com.alex.bean;

import java.util.Set;

/**
 * Created by Alex on 2016/12/24.
 */
public class Clazz {
	
	private Integer cid;
	private String cname;
	private Set<Student> students;
	
	public Clazz() {
	}
	
	public Clazz(String cname) {
		
		this.cname = cname;
	}
	
	public Integer getCid() {
		return cid;
	}
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Clazz{" +
					   "cid=" + cid +
					   ", cname='" + cname + '\'' +
					   ", students=" + students +
					   '}';
	}
}
