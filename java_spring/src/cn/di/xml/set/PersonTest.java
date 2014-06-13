package cn.di.xml.set;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	
	static{
		path = "cn/di/xml/set/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Person person = (Person) context.getBean("Person");
		person.getStudent().say();
		
		
	}
	
}
