package com.example.lottery.consumer.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(name = "restClient", havingValue = "useFeign")
@Service
public class FeignClientLotteryConsumerService {

	private final LotteryService lotteryService;

	public FeignClientLotteryConsumerService(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}
	
	@Scheduled(fixedRateString = "${callRate}")
	public void callLotteryService() {
		System.out.println("Received response: %s".formatted(lotteryService.getLotteryNumbers(5)));	
	}
}
