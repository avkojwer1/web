package cn.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLister implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.err.println("requst has been destoryed");
		Object o = sre.getSource();
		System.out.println("source object:" + o.hashCode());	
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request has been created:");
		Object o = sre.getSource();
		System.out.println("source object:" + o.hashCode());
	}

}
