package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.Student;
import com.register.service.StudentIService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	StudentIService studentService;

	@PostMapping("/insert")
	public Student insert(@RequestBody Student student) throws NullPointerException {
		System.out.println(student);
		studentService.insertData(student);
		return student;
	}

	@PostMapping("/delete")
	public Student deleteStudent(@RequestBody Student student) throws NullPointerException {
		System.out.println(student);
		studentService.DeleteData(student);
		return student;
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) throws NullPointerException {
		studentService.updateData(student);
		return student;
	}

	@GetMapping("/getList")
	public List<Student> studentList() {
		List<Student> studentList = studentService.getStudentList();
		System.out.println(studentList);
		return studentList;
	}

	@GetMapping("/getStudent")
	public Student studentDetail(@RequestBody Student student) {
		studentService.getStudent(student);
		return student;
	}
}