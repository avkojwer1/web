package cn.dao;

import java.io.Serializable;
import java.util.Collection;

import cn.domain.Person;

public interface IPersonDao {
	
	public void savePerson(Person person);
	
	public Person getPersonById(String id);
	
	public Collection<Person> getPersonAll();
}
