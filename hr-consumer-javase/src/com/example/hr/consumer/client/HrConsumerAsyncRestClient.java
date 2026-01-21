package com.example.hr.consumer.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.TimeUnit;

public class HrConsumerAsyncRestClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		var httpClient = HttpClient.newBuilder().build();
		var employeeRequest = HttpRequest
				.newBuilder(URI.create("http://localhost:2026/hr/api/v1/employees/89284227136")).build();
		var employeePhotoRequest = HttpRequest
				.newBuilder(URI.create("http://localhost:2026/hr/api/v1/employees/89284227136/photo")).build();
		httpClient.sendAsync(employeeRequest, BodyHandlers.ofString())
		          .thenAcceptAsync(employeeResponse -> System.out.println(employeeResponse.body()));
		httpClient.sendAsync(employeePhotoRequest, BodyHandlers.ofString())
		          .thenAcceptAsync(employeePhotoResponse -> System.out.println(employeePhotoResponse.body()));
		TimeUnit.SECONDS.sleep(8);
	}

}
