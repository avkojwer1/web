package cn.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper{
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setPid(rs.getLong("cid"));
		person.setPname(rs.getString("cname"));
		return null;
	}
	
}
