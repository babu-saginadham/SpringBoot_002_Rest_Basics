package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/C0")
public class C0_Controller {

	
	@PostMapping("/create")
	//@GetMapping("/create")
	public String create() {
		//DB Calls
		return "101";
	}
	
	@PostMapping("/create1")
	public ResponseEntity<String> create1() {
		ResponseEntity<String> resp = new ResponseEntity<String>("101", HttpStatus.CREATED);
		return resp;
		
	}
	
	@PostMapping("/create2")
	public ResponseEntity create2() {
		ResponseEntity<String> resp = new ResponseEntity<String>(HttpStatus.OK);
		return resp;
		
	}

	
}
