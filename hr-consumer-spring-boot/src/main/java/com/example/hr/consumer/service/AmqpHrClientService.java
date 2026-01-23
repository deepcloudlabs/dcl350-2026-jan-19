package com.example.hr.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AmqpHrClientService {

	@RabbitListener(queues = "${queueName}")
	public void handleHrEvents(String hrEvent) {
		System.err.println("[%s] New event has been received from RabbitMQ: %s".formatted(Thread.currentThread().getName(),hrEvent));
	}
}
