package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/greet")
	 public String greet() {
		// TODO Auto-generated method stub
		 return "Good afternoon Sandy1";

	}
	@GetMapping("/hi")
	 public String hi() {
		// TODO Auto-generated method stub
		 return "This is Rest API's";

	}
}
