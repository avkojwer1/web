package cn.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.domain.Person;
import cn.domain.Student;

public class PersonTest {

	public static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();

		sessionFactory = configuration.buildSessionFactory();
	}

	@Test
	public void testSave() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setPname("jingjing");
		person.setPsex("M");
		session.save(person);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testUpdate(){

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		/**
		 * 1、先把修改的那行提取出来
		 * 说明：
		 * 		Serializable是String和包装类的共同的父类   
		 */
		Person person = (Person) session.get(Person.class, 2L);
		person.setPname("denny");
			
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testQuery(){
		
		Session session = sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		System.out.println(personList);
		
		
	}
	
	@Test
	public void testDelete(){
		/*
		Session  session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Person person = new Person();
		person.setPid(1L);
		
		session.delete(person);
		transaction.commit();
		session.close();
		*/
	}
	

	
	
}
