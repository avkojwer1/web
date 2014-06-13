package cn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent se) {
		String name = se.getName();
		Object value = se.getValue();
		System.out.println("Add new attribute name:" + name);
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		String name = se.getName();
		Object value = se.getValue();
		System.out.println("remove new attribute name:" + name);
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		String name = se.getName();
		Object value = se.getValue();
		System.out.println("old attribute value:" + value);
		System.out.println("new attribute value:" + se.getSession().getAttribute(name));
	}

}
