package cn.mvc;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class PersonDaoImp implements PersonDao{

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

}
