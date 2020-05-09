package com.animal.restfull.resfull_API.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
	
@RestController
public class VersioninController {

	@GetMapping("/v1")
	public PersonV1 personV1(){
		return new PersonV1("karthik");
	}
	@GetMapping("/v2")
	public PersonV2 personV2(){
		return new PersonV2(new Name("Halesh","LJ"));
	}
	
	//using PARAM REQUEST
	
	@GetMapping(value="/person/param", params="version=1")
	public PersonV2 paramV1(){
		return new PersonV2(new Name("Halesh","LJ"));
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2(){
		return new PersonV2(new Name("KARTHIK","KUMAR"));
	}
	
	//using HEADER REQUEST
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV2 headerV1(){
		return new PersonV2(new Name("Halesh","LJ"));
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2(){
		return new PersonV2(new Name("KARTHIK","KUMAR"));
	}
	
	//using PRODUCES REQUEST
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV2 producesV1(){
		return new PersonV2(new Name("Halesh","LJ"));
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2(){
		return new PersonV2(new Name("KARTHIK","KUMAR"));
	}
	
}
