package cn.test;

import org.junit.Test;

import cn.domain.Department;
import cn.service.DepartmentService;

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
