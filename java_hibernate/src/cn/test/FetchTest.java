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
		// 加载配置文件
		configuration.configure();
		// 采用了工厂模式创建sessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}

	/*
	 * * 查询所有的班级 * 根据班级中的每一个cid去学生表中进行查询 n+1条查询
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
