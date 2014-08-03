package cn.test.service;

import org.junit.Test;

import cn.domain.Department;
import cn.service.DepartmentService;
import cn.test.BaseSpring;

public class DepartmentServiceTest extends BaseSpring{
	
	@Test
	public void test(){
		DepartmentService service = (DepartmentService) context.getBean("departmentService");
		service.getAllDepartment();
	}
	
	@Test
	public void save(){
		DepartmentService service = (DepartmentService) context.getBean("departmentService");
		Department dp = new Department();
		dp.setName("公关");
		service.saveDepartment(dp);
	}
}
