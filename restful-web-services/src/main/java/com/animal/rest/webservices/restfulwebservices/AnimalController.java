package com.animal.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

	@RequestMapping(method=RequestMethod.GET, path="/animal")
	public String animal(){
		return "animal list";
	}
}
