package cn.spring.hibernate.transaction.xml;

import org.junit.Test;

import cn.spring.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
	
		path = "cn/spring/hibernate/transaction/xml/applicationContext.xml";  
	}
	 
	
	@Test
	public void save(){
		PersonService service = (PersonService) context.getBean("personService");
		Person p = new Person();
		p.setPname("hello");
		p.setPsex("W");
		
		Person p2 = new Person();
		p2.setPname("hello");
		p2.setPsex("W");
		service.savePerson(p);
		int a = 1/0;
		service.savePerson(p2);
		
	}
	
}
