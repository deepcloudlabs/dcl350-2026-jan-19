package com.example.lottery.service;

import java.util.List;

import com.example.lottery.model.LotteryModel;

public interface LotteryService {
	LotteryModel draw();

	List<LotteryModel> draw(int column);
}
