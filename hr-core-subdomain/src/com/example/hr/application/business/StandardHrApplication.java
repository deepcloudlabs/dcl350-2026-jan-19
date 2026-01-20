package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Rate;
import com.example.hr.domain.TcKimlikNo;

@Application(HrApplication.class)
public class StandardHrApplication implements HrApplication {

	@Override
	public Employee hireEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo identity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Employee> increaseSalary(TcKimlikNo identity, Rate rate) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Employee> getEmployee(TcKimlikNo identity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
