package cn.extend;

import org.junit.Test;

import cn.spring.SpringHelper;


public class PersonTest extends SpringHelper{
	static{
		path = "cn/extend/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Student student = (Student)context.getBean("student");
		student.say();
	}
}
