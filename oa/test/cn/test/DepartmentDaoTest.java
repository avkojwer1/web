package cn.test;

import org.junit.Test;

public class DepartmentDaoTest extends BaseSpring{
	
	@Test
	public void test(){
		context.getBean("departmentDao");
	}
}
