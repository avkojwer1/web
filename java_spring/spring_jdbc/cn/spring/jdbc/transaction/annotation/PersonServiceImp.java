package cn.spring.jdbc.transaction.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
public class PersonServiceImp implements PersonService{
	
	@Resource(name="personDao")
	private PersonDao personDao;
	
	@Override
	@Transactional(readOnly=false)
	public void savePerson() {
		personDao.savePerson();
	}

}
