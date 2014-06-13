package cn.pattern;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		System.out.println("BookAction **********excute()");
		return "success";
	}
	
	public String add(){
		System.out.println("BookAction **********add()");
		return "success";
	}
	
}
