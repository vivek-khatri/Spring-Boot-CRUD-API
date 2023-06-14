package com.caps.app.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caps.app.ws.model.response.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
