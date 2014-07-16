package cn.service.impl;

import java.io.Serializable;

import cn.dao.PersonDao;
import cn.domain.Person;
import cn.service.PersonService;

public class PersonServiceImpl implements PersonService{
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	private PersonDao personDao;
	
	public void savePerson(Person person){
		personDao.savePerson(person);
	}

	public Person getPersonBeanPerson(Serializable id) {
		
		return personDao.getPersonBeanPerson(id);
	}
}
