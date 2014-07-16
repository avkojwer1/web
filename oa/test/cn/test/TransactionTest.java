package cn.test;

import org.junit.Test;

import cn.domain.Person;
import cn.service.PersonService;

public class TransactionTest extends BaseSpring{
	
	@Test
	public void testHibernate(){
		PersonService personService =  (PersonService) context.getBean("personService");
		Person person = personService.getPersonBeanPerson(1L);
		System.out.println(person.getPname());
	}
}
