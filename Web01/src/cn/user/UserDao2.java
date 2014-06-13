package cn.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;

import cn.utils.DataSourceUtils;



public class UserDao2 {
	public void save(){
		String sql = "insert into users values(?,?,?,?)";
		QueryRunner run = new QueryRunner();
		try {
			Connection con = DataSourceUtils.getConn();
			run.update(con,sql,
					UUID.randomUUID().toString().replace("-","")
					,"Jack1","333");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
