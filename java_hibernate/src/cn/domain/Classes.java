package cn.domain;

import java.io.Serializable;
import java.util.Set;

public class Classes implements Serializable{
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private Long cid;
	private String cname;
	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", description="
				+ description + ", students=" + students + "]";
	}
	private String description;
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	private Set<Student> students;
	
	
}
