package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;

@RestController
@RequestMapping(value="/api/body11")
public class C4_RequestBody_And_RespBody_Controller {
	
	/**
	 * 
	 * HTTP Status
	 * 
	 * 
	 */

	static Map<Integer, Student> students = new HashMap<>();
	static int i = 1;
	
	@GetMapping(value="/getAll")
	public Map<Integer, Student> get() {
		return students;
	}
	
	
	@PostMapping(value="/post")
	public ResponseEntity<String> post(@RequestBody Student student) {
		students.put(i++, student);
		return ResponseEntity.status(HttpStatus.CREATED).body("student inserted succesfully");
	}
	
	@PutMapping(value="/put")
	public ResponseEntity<String> put(@RequestBody Student student) {
		int stud_id = student.getSno();
		
		if(students.get(stud_id) !=null) {
			students.put(stud_id, student);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student data not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body("updated succesfully");
	}

	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String> delete(@RequestBody Student student) {
		if(students.get(student.getSno()) !=null) {
			students.put(i++, student);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student data not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body("deleted succesfully");
	}
	
	

}
