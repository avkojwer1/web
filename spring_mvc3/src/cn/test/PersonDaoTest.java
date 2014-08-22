package cn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dao.IPersonDao;
import cn.domain.Person;

public class PersonDaoTest {
	
	public ApplicationContext context;
	
	@Test
	public void getPersonById(){
		context = new ClassPathXmlApplicationContext("bean.xml");
		IPersonDao personDao = (IPersonDao) context.getBean("personDao");
		
		personDao.getPersonById("1");
	}
	
	@Test
	public void savePerson(){
		context = new ClassPathXmlApplicationContext("bean.xml");
		IPersonDao personDao = (IPersonDao) context.getBean("personDao");
		Person person = new Person();
		person.setAddress("jiang sheng hao yuan");
		person.setAge(4);
		person.setName("duoduo");
		personDao.savePerson(person);
	}
	
	@Test
	public void getPersonAll(){
		context = new ClassPathXmlApplicationContext("bean.xml");
		IPersonDao personDao = (IPersonDao) context.getBean("personDao");
		
		System.out.println(personDao.getPersonAll().size());
	}
	
}	
