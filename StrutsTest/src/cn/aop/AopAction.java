package cn.aop;

import com.opensymphony.xwork2.ActionSupport;

public class AopAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("AopAction **************** excute()");
		
		
		return super.execute();
	}
	
}
