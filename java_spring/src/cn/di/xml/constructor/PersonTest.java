package cn.di.xml.constructor;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/di/xml/constructor/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Person person = (Person) context.getBean("person");
		person.getStudent().say();
	}
	
}
