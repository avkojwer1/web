package cn.context;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ContextAction extends ActionSupport {
	
	public String test(){
		
		
		System.out.println("ContextAction **********test()");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("username", "hello");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map sessionMap = ServletActionContext.getContext().getSession();
		sessionMap.put("username", "hello_session");
		
		ServletContext sc = ServletActionContext.getServletContext();
		sc.setAttribute("username", "hello_appliction");
		return "attr";
	}
	
	
}
