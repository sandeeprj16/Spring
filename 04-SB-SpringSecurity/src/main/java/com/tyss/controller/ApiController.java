package com.tyss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@GetMapping("/noSecurity")
	String NoSecurity() {
		return "Without security we access any time";
	}
	
	// when access data before Authentication must
	@GetMapping("/withSecurity")
	String WithSecurity() {
		return "With Security ask login";
	}
}
