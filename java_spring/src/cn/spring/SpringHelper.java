package cn.spring;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelper {
	
	public static String path;
	public static ApplicationContext context;
	
	@Before
	public void strartSpring(){
		context = new ClassPathXmlApplicationContext(path);
	}
	
}
