package cn.test;

import org.junit.Test;

public class TestObersver {
	
	@Test
	public void test(){
		Person person = new Person();
		System.err.println("pp:"+person);
		
		person.addPersonListener(new PersonListener() {
			
			public void running(PersonEvent personEvent) {
				System.err.println("你正在跑....."+personEvent.getSource());
				personEvent.getSource();
			}
		});
		
		person.run();
	}
	
}

class Person{
	private PersonListener pl;
	
	public void addPersonListener(PersonListener pl) {
		this.pl = pl;
	}
	
	public void run(){
		if(pl != null)
			pl.running(new PersonEvent(this));
		
		System.out.println("我正在跑步......");
	}
	
	
	
}

interface PersonListener{
	void running(PersonEvent personEvent);
}

class PersonEvent{
	
	public PersonEvent(Object obj){
		this.src = obj;
	}
	
	private Object src;
	
	public Object getSource() {
		return this.src;
	}
	
	
}



