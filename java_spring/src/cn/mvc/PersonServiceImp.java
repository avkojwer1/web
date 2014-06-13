package cn.mvc;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{
	
	@Resource(name="PersonDao")
	 private PersonDao personDao;

	@Override
	public void savePerson() {
		personDao.savePerson();
	}
		
	
}
