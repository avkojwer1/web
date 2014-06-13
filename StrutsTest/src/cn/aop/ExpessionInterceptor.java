package cn.aop;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class ExpessionInterceptor implements Interceptor {

	public void init() {
		System.out.println("ExpessionInterceptor ********* init()");

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ExpessionInterceptor ********* intercept()");

		// cn.itcast.aop.UserAction@15b5783��������Ķ���
		System.out
				.println("invocation.getAction() : " + invocation.getAction());

		// cn.itcast.aop.UserAction@15b5783����invocation.getAction()������ȡ����ͬһ�Ķ���
		System.out.println("invocation.getProxy().getAction() : "
				+ invocation.getProxy().getAction());

		// userAction_save���Զ��������ļ��е�action��ǩ��name���Ե�ֵ
		System.out.println("invocation.getProxy().getActionName() : "
				+ invocation.getProxy().getActionName());

		// save����Ӧ������ָ��Ҫִ�еķ�����
		System.out.println("invocation.getProxy().getMethod() : "
				+ invocation.getProxy().getMethod());

		// /aop���Զ��������ļ��е�package��ǩ��namespace���Ե�ֵ
		System.out.println("invocation.getProxy().getNamespace() : "
				+ invocation.getProxy().getNamespace());

		// null ���ؽ��
		System.out
				.println("invocation.getResult() : " + invocation.getResult());


		Map sessionMap = ServletActionContext.getContext().getSession();

		Object obj = sessionMap.get("user");

		if (obj == null || obj.equals("")) {
			return "error";
		} else {
			return "success";
		}
	}

	public void destroy() {
		System.out.println("ExpessionInterceptor ********* destroy()");

	}
}