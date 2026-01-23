package com.example.fundamentals.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.security.RolesAllowed;

@Service
public class BusinessService {

	@RolesAllowed("WEBADMIN")
	public int fun() {
		
		return 42;
	}
}
