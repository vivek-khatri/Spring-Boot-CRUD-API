package com.caps.app.ws;

import java.util.List;
import com.caps.app.ws.controller.StudentController;
import com.caps.app.ws.model.response.Student;
import com.caps.app.ws.repository.StudentRepository;
import com.caps.app.ws.student.service.StudentService;
import com.caps.app.ws.student.service.StudentServiceImpl;
import com.caps.app.ws.model.request.StudentDetails;
import com.caps.app.ws.model.request.UpdateStudentDetails;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class CRUD_APPTests {
	
	// Testing API
	StudentController studentController;
	StudentService studentService;
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	void test_getStudents() {
		studentService = new StudentServiceImpl(studentRepository);
		studentController = new StudentController(studentService);
		for(int i=0; i<4; i++) {
			Student student = new Student("Vivek", "Khatri", "B.E.", "Computer", 8, (long)(i+1)*1000000000);
			studentRepository.save(student);
		}
		
		List<Student> studentsFromGet = studentController.getStudents();
		for(int i=0; i<4; i++) {
			Student student = studentRepository.findById(studentsFromGet.get(i).getId()).orElse(null);
			Student studentFromGet = studentsFromGet.get(i);
			
			assertThat(true).isEqualTo(student.equals(studentFromGet));
		}
	}
	
	@Test
	void test_getStudent() {
		studentService = new StudentServiceImpl(studentRepository);
		studentController = new StudentController(studentService);
		Student student = new Student("Vivek", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		studentRepository.save(student);
		Student studentFromGet = (Student)studentController.getStudent(studentRepository.findAll().get(0).getId()).getBody();
		
		assertThat(true).isEqualTo(student.equals(studentFromGet));
	}
	
	@Test
	void test_createStudent() {
		studentService = new StudentServiceImpl(studentRepository);
		studentController = new StudentController(studentService);
		Student student = new Student("Vivek", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		StudentDetails studentDetails = new StudentDetails("Vivek", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		studentController.createStudent(studentDetails);
		Student studentFromPost = studentRepository.findAll().get(0);
		
		assertThat(true).isEqualTo(student.equals(studentFromPost));
	}
	
	@Test
	void test_updateStudent() {
		studentService = new StudentServiceImpl(studentRepository);
		studentController = new StudentController(studentService);
		Integer newSemister = 2;
		
		Student student = new Student("Vivek", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		studentRepository.save(student);
		UpdateStudentDetails updateStudentDetails = new UpdateStudentDetails();
		updateStudentDetails.setSemister(newSemister);
		studentController.updateStudent(studentRepository.findAll().get(0).getId(), updateStudentDetails);
		
		assertThat(studentRepository.findAll().get(0).getSemister()).isEqualTo(newSemister);
	}
	
	@Test
	void test_deleteStudent() {
		studentService = new StudentServiceImpl(studentRepository);
		studentController = new StudentController(studentService);
		Student student = new Student("Vivek", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		studentRepository.save(student);
		studentController.deleteStudent(studentRepository.findAll().get(0).getId());
		
		assertThat(0).isEqualTo(studentRepository.count());
	}
	
	@Test
	void test_deleteStudents() {
		studentService = new StudentServiceImpl(studentRepository);
		studentController = new StudentController(studentService);
		Student student1 = new Student("Vivek", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		Student student2 = new Student("Vicky", "Khatri", "B.E.", "Computer", 8, (long)1000000000);
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentController.deleteStudents();
		
		assertThat(0).isEqualTo(studentRepository.count());
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Setting up");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Tearing Down");
		studentRepository.deleteAll();
	}
}
