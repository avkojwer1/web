package cn.salary;

import cn.salary.proxy.Logger;
import cn.salary.proxy.Privilege;
import cn.salary.proxy.Security;

public class SalaryManager {
	
	private Logger logger;
	private Security security;
	private Privilege privilege;
	
	
	public SalaryManager(Logger logger, Security security, Privilege privilege) {
		this.logger = logger;
		this.security = security;
		this.privilege = privilege;
	}



	public void showSalary(){
		this.logger.logging();
		this.security.security();
		if("admin".equals(this.privilege.getAccess())){
			System.out.println("5500 rmb");
		}
	}
	
}
