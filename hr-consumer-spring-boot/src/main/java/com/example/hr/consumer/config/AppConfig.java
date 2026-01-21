package com.example.hr.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableWebSocket
@EnableScheduling
public class AppConfig {

	@Bean
	RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	WebSocketClient createWebSocketClient() {
		return new StandardWebSocketClient();
	}
}
