package com.caps.app.ws.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	private String lastName;
	@Column(name = "course", nullable = false)
	private String course;
	@Column(name = "department", nullable = false)
	private String department;
	@Column(name = "semister", nullable = false)
	private Integer semister;
	
	@Column(name = "contactNumber", nullable = false)
	private Long contactNumber;
	
	public Student() {}

	public Student(String firstName, String lastName, String course, String department, Integer semister,
			Long contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.department = department;
		this.semister = semister;
		this.contactNumber = contactNumber;
	}

	public boolean equals(Student obj) {
		if (obj == null)
			return false;
		return this.firstName.equals(obj.getFirstName()) && this.lastName.equals(obj.getLastName()) && this.course.equals(obj.getCourse())
				&& this.department.equals(obj.getDepartment()) && this.semister.equals(obj.getSemister()) && this.contactNumber.equals(obj.getContactNumber());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getSemister() {
		return semister;
	}

	public void setSemister(Integer semister) {
		this.semister = semister;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
}
