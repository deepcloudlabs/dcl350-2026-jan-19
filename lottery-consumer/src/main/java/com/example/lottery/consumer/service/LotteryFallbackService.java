package com.example.lottery.consumer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lottery.consumer.dto.LotteryModel;

@Service
public class LotteryFallbackService implements LotteryService {

	@Override
	public List<LotteryModel> getLotteryNumbers(int column) {
		System.err.println("Fallback strategy is running...");
		return List.of(new LotteryModel(List.of(1,2,3,4,5,6)));
	}

}
