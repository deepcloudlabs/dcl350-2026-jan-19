package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.model.LotteryModel;
import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("/numbers")
@CrossOrigin
public class LotteryRestController {
	private final LotteryService lotteryService;
	private final int port;

	public LotteryRestController(LotteryService lotteryService, 
			@Value("${server.port}") int port) {
		this.lotteryService = lotteryService;
		this.port = port;
	}

	@GetMapping(params = { "column" })
	public List<LotteryModel> getLotteryNumbers(@RequestParam int column) {
		System.err.println("New request has arrived at port %d".formatted(port));
		return lotteryService.draw(column);
	}
}
