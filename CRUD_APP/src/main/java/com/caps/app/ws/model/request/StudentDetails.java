package com.caps.app.ws.model.request;

public class StudentDetails {
	private String firstName;
	private String lastName;
	private String course;
	private String department;
	private Integer semister;
	private Long contactNumber;

	public StudentDetails(String firstName, String lastName, String course, String department,
			Integer semister, Long contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.department = department;
		this.semister = semister;
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCourse() {
		return course;
	}

	public String getDepartment() {
		return department;
	}

	public Integer getSemister() {
		return semister;
	}

	public Long getContactNumber() {
		return contactNumber;
	}
}
