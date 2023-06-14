package com.caps.app.ws.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.app.ws.model.request.UpdateStudentDetails;
import com.caps.app.ws.model.exception.StudentServiceException;
import com.caps.app.ws.model.request.StudentDetails;
import com.caps.app.ws.model.response.Student;
import com.caps.app.ws.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;

	public StudentServiceImpl() {}
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		
		return students;
	}

	@Override
	public Student getStudent(long id) {
		Student student = studentRepository.findById(id).orElse(null);
		return student;
	}

	@Override
	public Student createStudent(StudentDetails studentDetails) {
		Student student;
		if (studentDetails.getFirstName() == null) {
			throw new StudentServiceException("First name can not be null.");
		} else if(studentDetails.getCourse() == null) {
			throw new StudentServiceException("Course details can not be null.");
		} else if (studentDetails.getDepartment() == null) {
			throw new StudentServiceException("Department details can not be null.");
		} else if (studentDetails.getSemister() == null) {
			throw new StudentServiceException("Semister details can not be null.");
		} else if (studentDetails.getContactNumber() == null) {
			throw new StudentServiceException("Contact number can not be empty/null.");
		} else if (Math.log10(studentDetails.getContactNumber()) < 9) {
			throw new StudentServiceException("Invalid contact number! Please enter valid contact number.");
		} else {
			student = new Student();
			student.setFirstName(studentDetails.getFirstName());
			student.setLastName(studentDetails.getLastName());
			student.setCourse(studentDetails.getCourse());
			student.setDepartment(studentDetails.getDepartment());
			student.setSemister(studentDetails.getSemister());
			student.setContactNumber(studentDetails.getContactNumber());
			studentRepository.save(student);
		}

		return student;
	}

	@Override
	public Student updateStudent(long id, UpdateStudentDetails updateStudentDetails) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student == null ) {
			throw new StudentServiceException("No such Student is exist!");
		} else if (updateStudentDetails.getSemister() == null) {
			throw new StudentServiceException("Semister details can not be null.");
		} else {
			student.setSemister(updateStudentDetails.getSemister());
			studentRepository.save(student);
		}

		return student;
	}

	@Override
	public boolean deleteStudent(long id) {
		if (studentRepository.findById(id).orElse(null) == null) {
			throw new StudentServiceException("No such Student is exist!");
		} else {
			studentRepository.deleteById(id);
		}
		
		return true;
	}

	@Override
	public boolean deleteStudents() {
		studentRepository.deleteAll();
		return false;
	}
}
