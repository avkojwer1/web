package cn.mvc.annotation;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("personDao")
public class PersonDaoImp implements PersonDao{

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

}
