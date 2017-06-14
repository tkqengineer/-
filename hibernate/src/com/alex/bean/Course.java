package com.alex.bean;

import java.util.Set;

/**
 * Created by Alex on 2016/12/24.
 */
public class Course {
	
	private Integer id;
	
	private  String name;
	
	private Set<Student> students;
	
	public Course() {
	}
	
	public Course(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Course{" +
					   "id=" + id +
					   ", name='" + name + '\'' +
					   ", students=" + students +
					   '}';
	}
}
