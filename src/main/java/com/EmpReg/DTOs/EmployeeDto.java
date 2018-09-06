package com.EmpReg.DTOs;

public class EmployeeDto {

	private Long EmpId;
	private String firstName;
	private String lastName;
	private int Age;
	private String Email;
	private String Gender;

	public EmployeeDto() {

	}

	public EmployeeDto(String firstName, String lastName, int Age, String Email, String Gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.Age = Age;
		this.Email = Email;
		this.Gender = Gender;
	}

	public Long getEmpId() {
		return EmpId;
	}

	public void setEmpId(Long empId) {
		EmpId = empId;
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

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

}
