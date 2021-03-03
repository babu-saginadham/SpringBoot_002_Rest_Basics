package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;

@RestController
@RequestMapping(value="/api/v44/student")
public class C5_PathParam_And_QueryParam_Controller {
	
	/**
	 * 
	 * HTTP Status
	 * 
	 * 
	 */

	static Map<Integer, Student> students = new HashMap<>();
	static int i = 1;
	
	@GetMapping
	public Map<Integer, Student> get() {
		return students;
	}
	
	@GetMapping
	public Map<Integer, Student> get1() {
		return students;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
		if(students.get(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(students.get(id));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student data not found");
		}
	}
	
	@GetMapping(value="/all2")
	public ResponseEntity<List<Student>> getStudent2(@RequestParam("startsWith") String nameStartsWith) {
		
		List<Student> studentList = new ArrayList<>();
		
		if(nameStartsWith != null) {
			studentList = students.values().stream()
				.filter(student -> student.getSname().startsWith(nameStartsWith)).collect(Collectors.toList());
		}else {
			studentList = students.values().stream().collect(Collectors.toList());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(studentList);
		
		
	}
	
	
	@PostMapping
	public ResponseEntity<String> post(@RequestBody Student student) {
		students.put(i++, student);
		return ResponseEntity.status(HttpStatus.CREATED).body("student inserted succesfully");
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<String> put(@PathVariable("id") Integer id, @RequestBody Student student) {
		
		System.out.println("Stud Id: " + id);
		if(students.get(id) !=null) {
			students.put(id, student);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student data not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body("updated succesfully");
	}

	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		if(students.get(id) != null) {
			students.remove(id);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student data not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body("deleted succesfully");
	}
	
	

}
