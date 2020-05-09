package com.animal.restfull.resfull_API.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class AnimalController {

	//GET
	//URI - /helloworld
	//method - "Hello World"
	@RequestMapping(method=RequestMethod.GET, path= "/animal_list")
	public String helloWorld(){
		return "Hello Karthik : welcome to REST api";
	}
	//GetMapping
	@GetMapping(path="/anotherMethod")
	public String helloMapping(){
		return "another method to call";
	}
	//Bean 
	@GetMapping("/helloBean")
	public AnimalBean helloWorldBean(){
		return new AnimalBean("Bean Message!!");
	}
	//PathVariable
	@GetMapping("/helloWorld/pathVavriable/{name}")
	public AnimalBean pathVariable(@PathVariable String name){
		return new AnimalBean(String.format("welocme to this page : %s",name));
	}
}
