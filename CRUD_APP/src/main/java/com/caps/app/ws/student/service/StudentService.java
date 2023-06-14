package com.caps.app.ws.student.service;

import java.util.List;

import com.caps.app.ws.model.request.UpdateStudentDetails;
import com.caps.app.ws.model.request.StudentDetails;
import com.caps.app.ws.model.response.Student;

public interface StudentService {
	List<Student> getStudents();
	Student getStudent(long id);
	Student createStudent(StudentDetails StudentDetails);
	Student updateStudent(long id, UpdateStudentDetails updateStudentDetails);
	boolean deleteStudent(long id);
	boolean deleteStudents();
}
