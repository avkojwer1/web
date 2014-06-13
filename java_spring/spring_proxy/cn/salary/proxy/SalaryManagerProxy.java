package cn.salary.proxy;

public class SalaryManagerProxy implements SalaryManager{

	/**
	 * 1、导入日志、安全性框架、权限 2、目标对象 3、在代理对象的方法中调用上述的方法
	 * 
	 * @author Administrator
	 * 
	 */
	
	private Logger logger;
	private Security security;
	private Privilege privilege;
	private SalaryManager target;
	
	public SalaryManagerProxy(Logger logger, Security security, Privilege privilege, SalaryManager target){
		this.logger = logger;
		this.security = security;
		this.privilege = privilege;
		this.target = target;
	}
	
	@Override
	public void showSalary() {
		
		this.logger.logging();
		this.security.security();
		if("admin".equals(this.privilege.getAccess())){
			target.showSalary();
		}
	}

}
