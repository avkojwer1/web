package cn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent se) {
		String key = se.getName();
		if(key.equals("user")){
			// seesion »º´æµ½servletContext
			
			
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		
	}

}
