package cn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.domain.Classes;

public class TwoCacheTest {
	/**
	 * 二级缓存
	 */
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		// 加载配置文件
		configuration.configure();
		// 采用了工厂模式创建sessionFactory
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
	 *   该方法只把对象放入到了一级缓存中，没有放入到二级缓存中
	 *   在执行session.flush的时候，把数据要保存到二级缓存中
	 */
	@Test
	public void testSave(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classes classes = new Classes();
		classes.setCname("0909java极品班");
		classes.setDescription("都是极品");
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
