package cn.salary.proxy;

import org.junit.Test;

import cn.salary.proxy.Logger;
import cn.salary.proxy.Privilege;
import cn.salary.proxy.Security;

public class SalaryTest {
	@Test
	public void test(){
		Logger logger = new Logger();
		Privilege privilege = new Privilege();
		Security security = new Security();
		SalaryManager target = new SalaryManagerImp();
		privilege.setAccess("admin");
		
		SalaryManager salaryManagerProxy = new SalaryManagerProxy(logger, security, privilege,target);
		
		salaryManagerProxy.showSalary();
	}
}
