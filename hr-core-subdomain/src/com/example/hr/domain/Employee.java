package com.example.hr.domain;

import com.example.ddd.helper.Entity;

// Domain --> sub-domain(s)    
//            core sub-domain  --> bounded-context       --> microservices -> process -> docker instance
// ubiquitous language: TcKimlikNo, FullName, Iban, Salary, Email, BirthYear, ...
//                      Domain Expert -> Distilled Knowledge -> 
//                      Knowledge Crunching    
//            analysis         --> design                     
@Entity(identites = { "identity" }, boundedContext = "hr")
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
}
