package cn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;

public class SessionTest {
	public static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void testGet(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, 1L);
		transaction.commit();
	}
	
}
