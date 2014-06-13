package cn.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest extends SpringHelper {
	
	static{
		path = "cn/spring/applicationContext.xml";
	}
	
    @Test
    public void test(){
         /*
         * 1、启动spring容器
         * 2、从spring容器中把helloWorld拿出来
         * 3、对象.方法
         */
         //启动spring容器
         HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");

         helloWorld.hello();
    }
}
