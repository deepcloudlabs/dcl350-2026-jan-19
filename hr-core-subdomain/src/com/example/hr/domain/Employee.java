package com.example.hr.domain;

import com.example.ddd.helper.Entity;

// Domain --> sub-domain(s)    
//            core sub-domain  --> bounded-context       --> microservices -> process -> docker instance
// ubiquitous language: TcKimlikNo, FullName, Iban, Salary, Email, BirthYear, ...
//                      Domain Expert -> Distilled Knowledge -> 
//                      Knowledge Crunching    
//            analysis         --> design                     
@Entity(identites = { "identity" }, boundedContext = "hr", aggregate= true)
public class Employee {
	private TcKimlikNo identity;
	private FullName fullName;
	private Iban iban;
	private Salary salary;
	private Email email;
	private BirthYear birthYear;
	private JobStyle jobStyle;
	private DepartmentList departments;
	private Photo photo;
	
	public Employee(TcKimlikNo identity, FullName fullName, Iban iban, Salary salary, Email email, BirthYear birthYear,
			JobStyle jobStyle, DepartmentList departments, Photo photo) {
		// Validation Rules
		// Invariants
		// Policies
		// Regulations
		// Business Rule		
		
		this.identity = identity;
		this.fullName = fullName;
		this.iban = iban;
		this.salary = salary;
		this.email = email;
		this.birthYear = birthYear;
		this.jobStyle = jobStyle;
		this.departments = departments;
		this.photo = photo;
	}
	
	public static class Builder {
		private TcKimlikNo identity;
		private FullName fullName;
		private Iban iban;
		private Salary salary;
		private Email email;
		private BirthYear birthYear;
		private JobStyle jobStyle;
		private DepartmentList departments;
		private Photo photo;

		
	}
	
}
