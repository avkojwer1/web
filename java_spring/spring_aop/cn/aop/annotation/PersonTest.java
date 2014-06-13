package cn.aop.annotation;

import org.junit.Test;

import cn.spring.SpringHelper;



public class PersonTest extends SpringHelper{
	static{
		path = "cn/aop/annotation/applicationContext.xml";
	}
	
	@Test
	public void test(){
		PersonDaoImpl personDao = (PersonDaoImpl)context.getBean("personDao");
		personDao.getPerson();
	}
}
