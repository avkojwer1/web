package cn.di.annotation;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/di/annotation/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Person person = (Person) context.getBean("person");
		person.say();
	}
	
}
