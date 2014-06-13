package cn.mvc;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	
	static{
		path = "cn/mvc//applicationContext.xml";
	}
	
	@Test
	public void testSave(){
		PersonAction action = (PersonAction) context.getBean("PersonAction");
		action.savePerson();
	}
	
	
}
