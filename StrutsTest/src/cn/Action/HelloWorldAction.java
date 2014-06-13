package cn.Action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport{

	public String execute() throws Exception {
		System.out.println("Hello World Action ************* excute method");
		return null;
	}

}
