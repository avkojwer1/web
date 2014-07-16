package cn.spring.hibernate.transaction.xml;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImp implements PersonDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void savePerson(Person person) {
		hibernateTemplate.save(person);
	}

}
