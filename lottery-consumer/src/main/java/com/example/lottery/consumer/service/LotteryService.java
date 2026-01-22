package com.example.lottery.consumer.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lottery.consumer.dto.LotteryModel;

@FeignClient(value = "lottery",fallback = LotteryFallbackService.class)
public interface LotteryService {

	@GetMapping(path = "/api/v1/numbers", params = { "column" })
	public List<LotteryModel> getLotteryNumbers(@RequestParam int column) ;

}
