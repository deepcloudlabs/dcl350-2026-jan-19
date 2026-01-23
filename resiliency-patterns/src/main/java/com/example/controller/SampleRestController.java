package com.example.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;

@RestController
@RequestMapping("/greeting")
public class SampleRestController {

	@GetMapping(params= {"name"})
	//@RateLimiter(name="sampleRestController")
	@Bulkhead(type = Type.SEMAPHORE, name = "sampleRestController")
	public String getMessage(@RequestParam String name) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
		return "[%s] Hello, %s!".formatted(Thread.currentThread().getName(),name);
	}
}
