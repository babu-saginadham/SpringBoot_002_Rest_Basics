package com.app.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;

@RestController
@RequestMapping(value="/api/v223", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class C2_ContentType_Controller2 {

	@GetMapping(value="/default")
	public Student default_() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}
	
	@GetMapping(value="/xml")
	public Student test() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}

	@GetMapping(value="/json")
	public ResponseEntity<Student> getUserById() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return ResponseEntity.ok().body(stud);
	}
	
	@GetMapping(value="/json-xml1")
	public ResponseEntity<Student> jsonXML() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return ResponseEntity.ok().body(stud);
	}
	
	@GetMapping(value="/json-xml2")
	public ResponseEntity<Student> jsonXML2() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return ResponseEntity.ok().body(stud);
	}

}
