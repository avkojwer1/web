package cn.spring.jdbc.transaction.annotation;

import javax.sql.DataSource;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/spring/jdbc/transaction/annotation/applicationContext.xml";  
	}
	
	@Test
	public void test(){
		PersonService personService = (PersonService) context.getBean("personService");
		personService.savePerson();
	}
	
}
