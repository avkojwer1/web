package cn.test;

import org.junit.Test;

public class SessionFactoryTest extends BaseSpring{
	
	@Test
	public void testSessionFactory(){
		context.getBean("sessionFactory");
	}
	
}
