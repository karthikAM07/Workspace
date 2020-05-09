package com.example.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitservice.bean.LimitConfiguration;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configuration;
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations(){
		return new LimitConfiguration(configuration.getMinimun(),configuration.getMaximum());
	}
}
