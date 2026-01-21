package com.example.hr.consumer.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class HrConsumerRestClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		var httpClient = HttpClient.newBuilder().build();
		var employeeRequest = HttpRequest
				.newBuilder(URI.create("http://localhost:2026/hr/api/v1/employees/89284227136")).build();
		var employeeResponse = httpClient.send(employeeRequest, BodyHandlers.ofString()).body();
		System.out.println(employeeResponse);
		var employeePhotoRequest = HttpRequest
				.newBuilder(URI.create("http://localhost:2026/hr/api/v1/employees/89284227136/photo")).build();
		var employeePhotoResponse = httpClient.send(employeePhotoRequest, BodyHandlers.ofString()).body();
		System.out.println(employeePhotoResponse);
	}

}
