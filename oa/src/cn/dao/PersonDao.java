package cn.dao;

import java.io.Serializable;

import cn.domain.Person;

public interface PersonDao {
	public void savePerson(Person person);
	public Person getPersonBeanPerson(Serializable id);
}
