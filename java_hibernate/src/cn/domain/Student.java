package cn.domain;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable{
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", description="
				+ description + ","+ "courses=" + courses
				+ "]";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	private Long sid;
	private String sname;
	private String description;
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	private Classes classes;
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	private Set<Course> courses;
	
}
