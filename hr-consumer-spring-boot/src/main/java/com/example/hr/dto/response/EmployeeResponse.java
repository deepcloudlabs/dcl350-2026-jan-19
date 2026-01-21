package com.example.hr.dto.response;

import java.util.List;

public record EmployeeResponse(
		String identity, 
		String firstName, 
		String lastName, 
		String iban,
		double salary,
		String currency,
		String email,
		int birthYear, 
		String jobStyle, 
		List<String> departments) {
}
