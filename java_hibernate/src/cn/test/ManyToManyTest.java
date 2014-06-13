package cn.test;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Course;
import cn.domain.Student;

public class ManyToManyTest {
	public static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void testSaveCourse(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Course course = new Course();
		course.setCname("java");
		
		session.save(course);
		transaction.commit();
		session.close();
		
	}
	
	@Test
	public void testSaveStudent(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setSname("duoduo");
		
		session.save(student);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testSaevCourse_Cascade(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = new Course();
		course.setCname("java base");
		Student student = new Student();
		student.setSname("meimei");
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		
		course.setStudents(students);
		session.save(course);
		transaction.commit();
		session.close();
	}
	
	/**
	 * �Ѿ�����һ���γ�, �½�һ��ѧ��, ���ҽ�����ѧ���͸ÿγ̼�Ĺ�ϵ
	 */
	@Test
	public void testSaveStudent_R(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Course course = (Course) session.get(Course.class, 1L);
		
		Student student = new Student();
		Set<Course> courses = new HashSet<Course>();
		courses.add(course);
		student.setCourses(courses);
		student.setSname("rongrong");
		
		session.save(student);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * �Ѿ�����һ��ѧ��, �Ѿ�����һ���γ�, �����ѧ����ԭ���γ�֮��Ĺ�ϵ
	 */
	@Test
	public void testRelase_Rebuild_R(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student =  (Student) session.get(Student.class, 14L);
		
		Course course = (Course) session.get(Course.class, 1L);
		Set<Course> courses = new HashSet<Course>();
		courses.add(course);
		
		student.setCourses(courses);
		
		transaction.commit();
		session.close();
		
	}
	
}