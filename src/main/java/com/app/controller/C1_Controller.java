package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class C1_Controller {
	
	
	
	@GetMapping("/test")
	//@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test() {
		return "Hello";
	}

	@GetMapping("/test2")
	public ResponseEntity<String> getUserById() {
		return ResponseEntity.ok().body("Helo");
	}

}
