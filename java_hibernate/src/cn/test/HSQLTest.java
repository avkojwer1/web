package cn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;
import cn.domain.Student;

public class HSQLTest {
	
	private static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration();
		//加载配置文件
		configuration.configure();
		//采用了工厂模式创建sessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void testClasses(){
		Session session = sessionFactory.openSession();
		List<Classes> classesList = session.createQuery("from Classes").list();
		System.out.println(classesList);
		session.close();

	}
	
	/**
	 * 等值连接
	 */
	@Test
	public void testSelect_Classes_Student_EQ(){
		Session session = sessionFactory.openSession();
		List classesList = session.createQuery("from Classes c,Student s where c.cid=s.classes.cid").list();
		classesList.size();
		session.close();
	}
	
	/**
	 * 迫切内连接
	 */
	@Test
	public void testSelect_Student_Classes_EQ_FETCH(){
		Session session = sessionFactory.openSession();
		List<Student> sList = session.createQuery("from Student s inner join fetch s.classes c").list();
		System.out.println(sList.size());
		for(Student s : sList){
			System.out.println(s);
		}

		session.close();
	}
	
	
	@Test
	public void testSelect_Classes_Student_Left(){
		Session session = sessionFactory.openSession();
		List classesList = session.createQuery("from Classes c left  join c.students s").list();
		classesList.size();
		System.out.println(classesList);
		session.close();
	}
	
}
