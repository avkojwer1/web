package cn.salary;

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
		privilege.setAccess("admin");
		SalaryManager salaryManager = new SalaryManager(logger, security, privilege);
		salaryManager.showSalary();
	}
}