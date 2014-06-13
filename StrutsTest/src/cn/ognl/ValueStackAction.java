package cn.ognl;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		
		System.out.println("ValueStackAction *************** execute()");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("username","jingjing_request");
		request.setAttribute("password","jingjing_pwd_request");
		
		Map sessionMap =  ServletActionContext.getContext().getSession();
		sessionMap.put("username", "username_session");
		sessionMap.put("password","jingjing_pwd_request");
		
		ServletContext sc = ServletActionContext.getServletContext();
		sc.setAttribute("username", "username_app");
		sc.setAttribute("password","jingjing_pwd_app");
		
		ValueStack valueStack = (ValueStack) request.getAttribute("struts.valueStack");
		System.out.println("valueStack = " + valueStack);
		
//		ValueStack valueStack2 =  ServletActionContext.getContext().getValueStack();
//		System.out.println("valueStack2 = " + valueStack2);		
		
		
		return super.execute();
	}
}
