package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/home")
public class HomeController{
	//http://localhost/springmvc/home/a
	@RequestMapping(value="/a")
	public String method1(String id){
		System.out.println("--------method1" + id);
		return "home";
	}
	
	@RequestMapping(value="/b")
	public String method2(){
		return "";
	}
}
