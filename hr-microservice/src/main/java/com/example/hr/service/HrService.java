package com.example.hr.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.application.HrApplication;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.request.IncreaseSalaryRequest;
import com.example.hr.dto.response.EmployeePhotoResponse;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;

@Service
public class HrService {
	private final HrApplication hrApplication;
	
	public HrService(HrApplication hrApplication) {
		this.hrApplication = hrApplication;
	}

	@Transactional
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public EmployeeResponse fireEmployee(String identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public EmployeeResponse increaseSalary(String identity, IncreaseSalaryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public EmployeeResponse getEmployee(String identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public EmployeePhotoResponse getEmployeePhoto(String identity) {
		// TODO Auto-generated method stub
		return null;
	}

}
