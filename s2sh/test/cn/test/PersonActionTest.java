package cn.test;

import org.junit.Test;

import cn.struts2.action.PersonAction;

public class PersonActionTest extends BaseSpring{
	
	@Test
	public void test(){
		PersonAction action = (PersonAction) context.getBean("personAction");
		action.savePerson();
	}
}
