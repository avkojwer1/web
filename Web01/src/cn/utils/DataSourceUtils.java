package cn.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DataSourceUtils {
	
	//// �����ֲ߳̾�������
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	private static DataSource ds;
	static {
		ds = // Ĭ�ϵĶ�ȡc3p0-config.xml��Ĭ������
		new ComboPooledDataSource();
	}
	
	public static DataSource getDatasSource() {
		return ds;
	}

	public static Connection getConn()  {
		// �ȴ�tl��������л�ȡһ�����ݣ������ǰ�߳��Ѿ������connection��ֱ�ӷ������connecton
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
