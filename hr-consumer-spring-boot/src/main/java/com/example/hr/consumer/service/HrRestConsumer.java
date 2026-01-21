package com.example.hr.consumer.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.hr.dto.response.EmployeeResponse;

@Service
public class HrRestConsumer {
	private final RestTemplate restTemplate;
	
	public HrRestConsumer(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Scheduled(fixedRate = 5_000)
	public void callHrService() {
		var employee = restTemplate.getForObject("http://localhost:2026/hr/api/v1/employees/89284227136", EmployeeResponse.class);
		System.out.println(employee);
	}
}
