package cn.aop.xml.salary;

import org.junit.Test;

import cn.salary.proxy.Logger;
import cn.salary.proxy.Privilege;
import cn.salary.proxy.Security;
import cn.spring.SpringHelper;

public class SalaryTest extends SpringHelper{
	
	static{
		path = "cn/aop/xml/salary/applicationContext.xml";
	}
	
	
	@Test
	public void test(){
		SalaryManager sarManager = (SalaryManager) context.getBean("salaryManager");
		sarManager.showSalary2();
	}
}
