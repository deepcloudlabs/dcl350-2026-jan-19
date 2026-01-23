package com.example.fundamentals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fundamentals.service.BusinessService;

import java.security.Principal;

@RestController
public class SimpleSecureController {
	private final BusinessService businessService;
	
    public SimpleSecureController(BusinessService businessService) {
		this.businessService = businessService;
	}

	@GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    @GetMapping("/secure")
    public String secureEndpoint(Principal principal) {
        return "[%s] This is a secured endpoint: %d".formatted(principal,businessService.fun());
    }
}
