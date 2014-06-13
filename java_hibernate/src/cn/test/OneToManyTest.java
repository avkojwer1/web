package cn.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;
import cn.domain.Student;

public class OneToManyTest {
	public static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void AddClassesTest(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = new Classes();
		classes.setCname("doudou1");
		classes.setDescription("duoduo class");
		
		session.save(classes);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testSaveStudent(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setSname("duoduo");
		student.setDescription("duoduo");
		
		session.save(student);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testSaveStudentAndClasses(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setSname("duoduo");
		student.setDescription("duoduo");

		
		Set<Student> set = new HashSet<Student>();
		set.add(student);
		
		Classes classes = new Classes();
		classes.setCname("doudou1");
		classes.setDescription("duoduo class");
		classes.setStudents(set);
				
		session.save(classes);
		
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 重新建立班级和学生的关系
	 */
	@Test
	public void testReset_ALL(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	
		Classes classes = (Classes)session.get(Classes.class, 4L);
		List<Student> students = session.createQuery("from Student where sid in (3,4,5)").list();
		classes.setStudents(new HashSet<Student>(students));

		transaction.commit();
		session.close();
	}
	
/**
 * 解除班级和所有学生间的关系
 */

	@Test
	public void testRealseAll_R(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes)session.get(Classes.class, 4L);
		
		classes.setStudents(null);
		
		transaction.commit();
		session.close();
	}
	
	//删除班级
	@Test
	public void TestDeleteClass(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes)session.get(Classes.class, 4L);
		session.delete(classes);
		
		transaction.commit();
		session.close();
	}
	
	
}
