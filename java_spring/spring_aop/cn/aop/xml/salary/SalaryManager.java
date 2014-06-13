package cn.aop.xml.salary;

public class SalaryManager{

	/**
	 * 1、导入日志、安全性框架、权限 2、目标对象 3、在代理对象的方法中调用上述的方法
	 * 
	 * @author Administrator
	 * 
	 */
	
	private Logger logger;
	private Security security;
	private Privilege privilege;
	
	
	public void showSalary() {

		System.out.println("show salary");
	}

	public void showSalary2() {
			int a = 1/0;
		System.out.println("show salary");
	}
}
