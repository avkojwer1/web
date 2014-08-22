package cn.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.IPersonDao;
import cn.domain.Person;

@Service("personService")
public class PersonService {
	
	@Resource(name="personDao")
	public IPersonDao personDao;
	
	@Transactional(readOnly=false)
	public void savePerson(Person person){
		personDao.savePerson(person);
	}
	
	public Collection<Person> getAllPerson(){
		return personDao.getPersonAll();
	}
}
