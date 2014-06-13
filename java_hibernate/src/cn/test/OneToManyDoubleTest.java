package cn.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;
import cn.domain.Student;

public class OneToManyDoubleTest {
	public static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveClass(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = new Classes();
		classes.setCname("doudou2");
		classes.setDescription("doudou2");
		
		Student student = new Student();
		student.setSname("xiaoxue");
		student.setDescription("tu gou");
		//ͨ��student ������classes�Ĺ�ϵ
		student.setClasses(classes);
		
		session.save(student);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testSaveStudent_R(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, 10L);
		
		
		Student student = new Student();
		student.setSname("xiaoxue");
		student.setDescription("tu gou");
		student.setClasses(classes);
		
		session.save(student);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testRealse_Rebuild_R(){
		/**
		 * 1. ��ȡ�༶
		 * 2. ��ȡ�༶��ѧ��
		 * 3. ����ѧ��
		 * 4.��ѧ���༶����Ϊnull
		 * 5. ��������ѧ��
		 */
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, 10L);
		
		Set<Student>  students = classes.getStudents();
		for (Student student : students) {
			student.setClasses(null);
		}
		
		Student student2 = new Student();
		student2.setSname("xxxxxx");
		student2.setDescription("helo");
		//student2.setClasses(classes);
		
		students.add(student2);
		transaction.commit();
		session.close();
		
	}
	
}
