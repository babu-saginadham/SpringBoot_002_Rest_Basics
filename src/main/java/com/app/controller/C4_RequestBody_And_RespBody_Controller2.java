package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping(value="/api/v33")
public class C4_RequestBody_And_RespBody_Controller2 {
	
	/**
	 * 
	 * @RequestBody
	 * 
	 * Destination:
	 * 
	 * COllects all the params
	 * sno
	 * sname
	 * sname1
	 * 
	 * Source:
	 * Student stud = new Student();
	 * sno:
	 * stud.setSno(101);
	 * 
	 * sname:
	 * stud.setSname("Babu");
	 * 
	 * 
	 */
	@PostMapping("/create")
	public int createStudent(@RequestBody Student student) {
		
		System.out.println("Student Name: " + student.getSname());
		
		int sno = 1;
		return sno;
	}
	
	//productcat/{cat}/
	//product/{mobiles}/company/{samsung}
	//product/{mobiles}/{samsung}
	@PutMapping("/update/{sno}")
	public String updateStudent(@PathVariable(value = "sno") String sno, @RequestBody Student student) {
		
		System.out.println("Student no: " + sno);
	
		System.out.println("Student name: " + student.getSname());
		
		return "success";
	}
	
	@DeleteMapping("/delete/{sno}")
	public String deleteStudent(@PathVariable("sno") Integer sno) {
		System.out.println("Student no: " + sno);
		return "success";
	}
	
	@GetMapping("/student/all")
	public List<Student> getAllTheStudents(
			@RequestBody Student student,
			@RequestParam(name = "namesStartsWith", required = false) String namesStartsWith,
			@RequestParam(name = "className", required = false) String className,
			@RequestParam(name = "address", required = false) String address
			) {
		
		System.out.println("namesStartsWith:" + namesStartsWith);
		List<Student> list = new ArrayList<>();
		Student stud1 = new Student();
		stud1.setSno(101);
		stud1.setSname("Bbau");
		list.add(stud1);
		
		Student stud2 = new Student();
		stud2.setSno(102);
		stud2.setSname("XYZ");
		list.add(stud2);
		
		return list;
	}
	
	@GetMapping("/student/{sno}")
	public Student getSpecificStudent(@PathParam("sno") Integer sno) {
		
		Student stud2 = new Student();
		stud2.setSno(102);
		stud2.setSname("XYZ");

		return stud2;
	
	}
	
	
	
	

}
