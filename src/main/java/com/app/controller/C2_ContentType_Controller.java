package com.app.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;

@RestController
@RequestMapping(value="/api/v22")
public class C2_ContentType_Controller {

	//@RequestMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(value="/xml", produces = {MediaType.APPLICATION_XML_VALUE})
	
	@GetMapping(value="/default")
	public Student default_() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}
	
	@GetMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public Student test() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}

	@GetMapping(value="/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getUserById() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return ResponseEntity.ok().body(stud);
	}
	
	@GetMapping(value="/json-xml1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Student> jsonXML() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return ResponseEntity.ok().body(stud);
	}
	
	@GetMapping(value="/json-xml2", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Student> jsonXML2() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return ResponseEntity.ok().body(stud);
	}

}
