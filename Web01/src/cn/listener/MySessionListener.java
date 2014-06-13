package cn.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	private Integer online =1;
	
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("visitor:" + se.getSource());
		HttpSession hs1 = se.getSession();
		System.out.println("session id:" + hs1.getId());
		
		//获取整个域的对象
		ServletContext sc =  se.getSession().getServletContext();
		sc.setAttribute("online", online++);
		
		
		List<HttpSession> list = (List<HttpSession>) sc.getAttribute("sessions");
		if(list == null){
			list = new ArrayList<HttpSession>();
		}
		list.add(hs1);
		sc.setAttribute("sessions", list);
		System.out.println("set seesion.");
	}
	
	
	
	
	
	
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("有人退出" + se.getSource());
		ServletContext sc =  se.getSession().getServletContext();
		sc.setAttribute("online", online--);
	}

}
