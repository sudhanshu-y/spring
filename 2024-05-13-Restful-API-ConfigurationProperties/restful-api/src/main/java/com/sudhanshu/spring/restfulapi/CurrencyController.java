package com.sudhanshu.spring.restfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyServiceConfiguration currencyServiceConfiguration;

	@GetMapping("/currency")
	public CurrencyServiceConfiguration getAllJavaCourses() {
		return currencyServiceConfiguration;
	}
}
