package com.example.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class IntegrationService {
	private static final AtomicInteger counter = new AtomicInteger();
	
	@Retry(name = "integrationService",fallbackMethod = "funFallback")
	@RateLimiter(name="integrationService2",fallbackMethod = "funFallback")
	public int fun() {
		try {TimeUnit.MILLISECONDS.sleep(10);} catch (InterruptedException e) {}
//		if(ThreadLocalRandom.current().nextInt(10)<9)
//			throw new IllegalStateException("Something is wrong!");
		return counter.getAndIncrement();
	}
	
	// 1. Default Value
	// 2. Cache Lookup
	// 3. Alternative Service
	// 4. Logging the error
	// faster & lightweight -> original call
	public int funFallback(Throwable t) {
		System.err.println("funFallback() is running: %s".formatted(t.getMessage()));
		return 108;
	}
	
	@RateLimiter(name="integrationService2")
	public int gun() {
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}
		return 3615;
	}
	
	@CircuitBreaker(name="integrationService3",fallbackMethod = "runFallback")
	public int run() {
		if(ThreadLocalRandom.current().nextInt(10)<2)
			throw new IllegalStateException("Something is wrong!");		
		return 3;
	}
	
	@TimeLimiter(name="sun",fallbackMethod = "sunFallback")
	public CompletableFuture<Integer> sun(){
		return CompletableFuture.supplyAsync(()->{
			try {
				int waitDuration = ThreadLocalRandom.current().nextInt(4, 10);
				System.out.println("waiting...%d".formatted(waitDuration));
			    TimeUnit.SECONDS.sleep(waitDuration);} catch (InterruptedException e) {}			
			return 42;
		});
	} 
	
	public CompletableFuture<Integer> sunFallback(Throwable t){
		return CompletableFuture.supplyAsync(()->{
			return 549;
		});
	}
	
	public int runFallback(Throwable t) {
		System.err.println(t.getMessage());
		return 3615;
	}

}
