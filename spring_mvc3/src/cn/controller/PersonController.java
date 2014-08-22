package cn.controller;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.domain.Person;
import cn.service.PersonService;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	@Resource(name="personService")
	public PersonService personService;
	
	@RequestMapping(value="/save")
	public String savePerson(){
		Person person = new Person();
		person.setAddress("jiasheng 30# 10001");
		person.setAge(25);
		person.setName("rongrong");
		
		personService.savePerson(person);
		System.out.println("save person");
		return "success";
	}
	
	
	@RequestMapping(value="/getAllPerson")
	public String getAllPerson(HttpServletRequest request){
		Collection<Person> personList = personService.getAllPerson();
		request.setAttribute("personList", personList);
		return "personList";
	}
	
	
}
