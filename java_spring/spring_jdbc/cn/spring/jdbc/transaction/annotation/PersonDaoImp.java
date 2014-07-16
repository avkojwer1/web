package cn.spring.jdbc.transaction.annotation;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImp implements PersonDao{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void savePerson() {
		jdbcTemplate.execute("insert into person(pname) value ('asdf')");
		int a  = 1/0;
		jdbcTemplate.execute("insert into person(pname) value ('asdfasdf')");
	}

}
