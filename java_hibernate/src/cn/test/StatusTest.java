package cn.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.domain.Person;

public class StatusTest {
	public static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		
		sessionFactory = configuration.buildSessionFactory();		
	}
	
	
	@Test
	public void status(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, 2L);
		person.setPname("greg");
		
		session.save(person);
		transaction.commit();
		session.close();
	}
	
	
	
}
