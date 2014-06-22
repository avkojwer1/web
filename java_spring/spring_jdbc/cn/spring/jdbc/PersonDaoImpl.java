package cn.spring.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao{

	@Override
	public void savePerson() {
		this.getJdbcTemplate().execute("insert into course(cid,cname) values(111,'aaa')");
	}
	
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query("select * from course", new PersonRowMapper());
	}
	
}
