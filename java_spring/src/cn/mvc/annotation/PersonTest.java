package cn.mvc.annotation;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	
	static{
		path = "cn/mvc/annotation/applicationContext.xml";
	}
	
	@Test
	public void testSave(){
		PersonAction action = (PersonAction) context.getBean("personAction");
		action.savePerson();
	}
	
	
}
