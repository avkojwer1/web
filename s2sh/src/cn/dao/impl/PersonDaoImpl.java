package cn.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.dao.PersonDao;
import cn.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

}
