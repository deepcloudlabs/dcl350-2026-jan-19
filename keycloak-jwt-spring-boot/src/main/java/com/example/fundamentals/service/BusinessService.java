package com.example.fundamentals.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

	@PreAuthorize("hasRole('WEBADMIN')")
	public int fun() {
		
		return 42;
	}
}
