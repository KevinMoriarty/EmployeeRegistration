package com.EmpReg.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{
	
	
	private static final long serialVersionUID = 5490019813483368428L;
	
	public Employee(String firstName, String lastName, int age, String email, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.Age = age;
		this.Email = email;
		this.Gender = gender;
	}
	
	public Employee() {

	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long EmpId;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Age")
	private int Age;
	
	@Column(name="EmailAddress")
	private String Email;
	
	@Column(name="Gender")
	private String Gender;

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
