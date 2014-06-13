package cn.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;
import cn.domain.Student;

public class FetchTest {

	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		// ���������ļ�
		configuration.configure();
		// �����˹���ģʽ����sessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}

	/*
	 * * ��ѯ���еİ༶ * ���ݰ༶�е�ÿһ��cidȥѧ�����н��в�ѯ n+1����ѯ
	 */
	@Test
	public void testQueryClasses() {
		Session session = sessionFactory.openSession();
		List<Classes> classesList = session.createQuery(
				"from Classes where cid in (10,1,2,3)").list();
		for (Classes classes : classesList) {
			Set<Student> students = classes.getStudents();
			for (Student student : students) {
				System.out.println(student.getSname());
			}
		}
		session.close();
	}

	/*
	 * * join
	 */
	@Test
	public void testJoinClasses() {
		Session session = sessionFactory.openSession();
		Classes classes = (Classes) session.get(Classes.class, 1L);

		Set<Student> students = classes.getStudents();
		for (Student student : students) {
			System.out.println(student.getSname());
		}

		session.close();
	}
}
