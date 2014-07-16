package cn.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.dao.PersonDao;
import cn.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}
	
	public Person getPersonBeanPerson(Serializable id){
		
		Person person = (Person) this.getHibernateTemplate().load(Person.class, id);
		return person;
	}
}
