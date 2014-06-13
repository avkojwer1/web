package cn.resulttype;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ResultTypeAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("ResultTypeAction **********excute()");
		
		//struct ��ܽ�request��װ��һ��map����
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("username", "username_request");
		
		return "success";
	}
	
}
