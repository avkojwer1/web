package cn.domain;

import java.io.Serializable;

public class Person implements Serializable{
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	private Long pid;
	private String pname;
}
