package cn.test;

import org.junit.Test;

import cn.domain.Person;
import cn.service.PersonService;

public class PersonServiceTest extends BaseSpring {
	
	@Test
	public void SavePersonTest(){
		PersonService personService = (PersonService) context.getBean("personService");
		Person person = new Person();
		person.setPname("duoduo");
		personService.savePerson(person);
	}
}
