package com.omerfpekgoz.springsample.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.omerfpekgoz.springsample.dtos.StudentRequest;
import com.omerfpekgoz.springsample.model.Student;
import com.omerfpekgoz.springsample.services.StudentService;

@RestController
@RequestMapping(value = "/student", produces = "application/json")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/list")
	public List<Student> gettAllStudent() {
		return studentService.getAllStudent();
	}

	@RequestMapping(value = "/list/{id}")
	public Optional<Student> findById(@PathVariable Long id) {
		return studentService.findById(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Student addStudent(@RequestBody StudentRequest request) {
		return studentService.addStudent(request);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Student updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
		return studentService.updatedStudent(id, request);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public boolean deleteDeveloper(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return true;
	}

}
