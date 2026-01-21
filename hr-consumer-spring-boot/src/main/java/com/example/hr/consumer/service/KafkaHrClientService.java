package com.example.hr.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaHrClientService {

	@KafkaListener(topics = "${topicName}", groupId = "hr-client")
	public void handleHrEvents(String hrEvent) {
		System.err.println("[%s] New event has been received from Kafka: %s".formatted(Thread.currentThread().getName(),hrEvent));
	}
}
