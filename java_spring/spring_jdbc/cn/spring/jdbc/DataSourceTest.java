package cn.spring.jdbc;

import javax.sql.DataSource;

import org.junit.Test;

import cn.spring.SpringHelper;

public class DataSourceTest extends SpringHelper{
	static{
		path = "cn/spring/jdbc/applicationContext.xml";
	}
	
	@Test
	public void testDataSouce(){
		
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
	}
	
}
