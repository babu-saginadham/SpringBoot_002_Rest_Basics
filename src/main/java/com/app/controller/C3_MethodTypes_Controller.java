package com.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;

@RestController
@RequestMapping(value="/api/methods")
public class C3_MethodTypes_Controller {

	@GetMapping(value="/get")
	public Student get() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}
	
	@PostMapping(value="/post")
	public Student post() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}

	
	@DeleteMapping(value="/delete")
	public Student delete() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}
	
	@PutMapping(value="/put")
	public Student put() {
		Student stud = new Student();
		stud.setSno(101);
		stud.setSname("Babu");
		return stud;
	}

}
