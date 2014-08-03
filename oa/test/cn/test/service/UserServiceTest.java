package cn.test.service;

import org.junit.Test;

import cn.service.UserService;
import cn.test.BaseSpring;

public class UserServiceTest extends BaseSpring{
	
	@Test
	public void getAllTest(){
		UserService service = (UserService) context.getBean("userService");
		service.getAllUsers();
	}
	
}
