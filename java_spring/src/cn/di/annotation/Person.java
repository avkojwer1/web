package cn.di.annotation;

import javax.annotation.Resource;

public class Person {
	
	@Resource
	//@Autowired//按照类型进行匹配
	//@Qualifier("student")
	private Student studen;
	
	@Resource
	private Long pid;
	
	public void say(){
		this.studen.say();
	}
}
