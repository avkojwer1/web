package cn.service;

import java.io.Serializable;

import cn.domain.Person;

public interface PersonService {
	public void savePerson(Person person);
	public Person getPersonBeanPerson(Serializable id);
}
