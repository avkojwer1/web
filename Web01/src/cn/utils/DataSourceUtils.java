package cn.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DataSourceUtils {
	
	//// 声明线程局部的容器
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	private static DataSource ds;
	static {
		ds = // 默认的读取c3p0-config.xml中默认配置
		new ComboPooledDataSource();
	}
	
	public static DataSource getDatasSource() {
		return ds;
	}

	public static Connection getConn()  {
		// 先从tl这个容器中获取一次数据，如果当前线程已经保存过connection则直接返回这个connecton
		Connection conn = tl.get();
		if(conn == null){
			try {
				conn =  ds.getConnection();
				tl.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}
	
	
}
