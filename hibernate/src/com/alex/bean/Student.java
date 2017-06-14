package com.alex.bean;

import java.util.Set;

/**
 * Created by Alex on 2016/12/24.
 */
public class Student {
	
	private Integer sid;
	private String sname;
	private Integer age;
	private Clazz clazz;
	
	private Set<Course> courses;
	
	public Set<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public Student() {
	}
	
	public Student(String sname, Integer age) {
	
		this.sname = sname;
		this.age = age;
		
	}
	
	public Integer getSid() {
		return sid;
	}
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Clazz getClazz() {
		return clazz;
	}
	
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public String toString() {
		return "Student{" +
					   "sid=" + sid +
					   ", sname='" + sname + '\'' +
					   ", age=" + age ;
					   
	}
}
