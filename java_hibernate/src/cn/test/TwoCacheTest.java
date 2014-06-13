package cn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;

public class TwoCacheTest {
	/**
	 * ��������
	 */
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		// ���������ļ�
		configuration.configure();
		// �����˹���ģʽ����sessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void test(){
		Session session = sessionFactory.openSession();
		Classes classes = (Classes) session.get(Classes.class, 10L);

		
		System.out.println(classes.getStudents().size());
		session.clear();
		
		 session = sessionFactory.openSession();
		 classes = (Classes) session.get(Classes.class, 10L);

		
			System.out.println(classes.getStudents().size());
		session.close();
	}
	
	/**
	 * session.save
	 *   �÷���ֻ�Ѷ�����뵽��һ�������У�û�з��뵽����������
	 *   ��ִ��session.flush��ʱ�򣬰�����Ҫ���浽����������
	 */
	@Test
	public void testSave(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = new Classes();
		classes.setCname("0909java��Ʒ��");
		classes.setDescription("���Ǽ�Ʒ");
		session.save(classes);
		//transaction.commit();
		//session.flush();
		session.close();
		session = sessionFactory.openSession();
		classes = (Classes)session.get(Classes.class, classes.getCid());
		transaction.commit();
		session.close();
	}
}
