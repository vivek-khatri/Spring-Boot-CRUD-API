package com.caps.app.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caps.app.ws.model.request.UpdateStudentDetails;
import com.caps.app.ws.model.request.StudentDetails;
import com.caps.app.ws.model.response.Student;
import com.caps.app.ws.student.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	public StudentController() {}
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping(path="/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> getStudent(@PathVariable long id) {
		Student responseValue = studentService.getStudent(id);
		if (responseValue != null) {
			return new ResponseEntity<Student>(responseValue, HttpStatus.OK);
		} else {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(
			consumes = { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public Student createStudent(@RequestBody StudentDetails studentDetails) {
		Student responseValue = studentService.createStudent(studentDetails);
		return responseValue;
	}
	
	@PutMapping(path="/{id}", 
			consumes = { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody UpdateStudentDetails updateStudentDetails) {
		Student storedStudent = studentService.updateStudent(id, updateStudentDetails);
		return new ResponseEntity<Student>(storedStudent, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteStudents() {
		studentService.deleteStudents();
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
}
