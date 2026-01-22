package com.example.lottery.consumer.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

@Service
@ConditionalOnProperty(name = "restClient", havingValue = "useRestTemplate")
public class LotteryConsumerService {
	private final static String LOTTERY_SERVICE_URL = "http://%s:%d/api/v1/numbers?column=5";
	private final static String LOTTERY_SERVICE_ID = "lottery";
	private final RestTemplate restTemplate;
	private final DiscoveryClient discoveryClient;
	private List<ServiceInstance> instances = List.of();
	private final AtomicInteger counter = new AtomicInteger(0);
	
	public LotteryConsumerService(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
		this.restTemplate = restTemplate;
		this.discoveryClient = discoveryClient;
	}

	@PostConstruct
	public void retrieveInstanceList() {
		this.instances  = discoveryClient.getInstances(LOTTERY_SERVICE_ID);
	}
	
	@Scheduled(fixedRateString = "${refreshRate}")
	public void refreshInstanceList() {
		this.instances  = discoveryClient.getInstances(LOTTERY_SERVICE_ID);
	}
	
	@Scheduled(fixedRateString = "${callRate}")
	public void callLotteryService() {
		var success = false;
		do {
			try {
				var instance = nextInstance();
				String serviceUrl = LOTTERY_SERVICE_URL.formatted(instance.getHost(),instance.getPort());
				var response = restTemplate.getForEntity(serviceUrl, String.class);			
				System.out.println("Received response from %s: %s".formatted(serviceUrl,response.getBody()));
				success = true;
			}catch (Throwable t) {
				System.err.println("Rest call has failed: %s".formatted(t.getMessage()));
				System.err.println("will retry in a second!");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshInstanceList();
			}			
		}while(!success);
	}

	private ServiceInstance nextInstance() {
		// round-robin strategy
		var nextIndex = counter.getAndIncrement() % instances.size();
		return instances.get(nextIndex);
	}
}
