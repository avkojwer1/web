package cn.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.domain.Person;

@Repository("personDao")
public class PersonDao implements IPersonDao{
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	public void savePerson(Person person) {
		hibernateTemplate.save(person);	
	}
	
	public Person getPersonById(String id){
		
		return hibernateTemplate.get(Person.class, id);
	}

	public Collection<Person> getPersonAll() {

		return 	hibernateTemplate.find("from " + Person.class.getName());
	}
	
}
