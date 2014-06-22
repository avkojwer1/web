package cn.spring.jdbc.transaction;

public class PersonServiceImp implements PersonService{
	
	 public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	private PersonDao personDao;
	
	@Override
	public void savePerson() {
		personDao.savePerson();
	}

}
