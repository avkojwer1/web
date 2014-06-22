package cn.spring.jdbc.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImp extends JdbcDaoSupport implements PersonDao{

	@Override
	public void savePerson() {
		this.getJdbcTemplate().execute("insert into person(pname) value ('asdf')");
		int a  = 1/0;
		this.getJdbcTemplate().execute("insert into person(pname) value ('asdfasdf')");
	}

}
