package com.example.hr.consumer.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class HrConsumerWebSocketClient {

	public static void main(String[] args) throws InterruptedException {
		var listener = new HrWbeSocketServiceListener();
		HttpClient.newHttpClient()
		          .newWebSocketBuilder()
		          .buildAsync(URI.create("ws://localhost:2026/hr/api/v1/hr-events"), listener);
		TimeUnit.MINUTES.sleep(30);
	}

}

class HrWbeSocketServiceListener implements Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
        System.err.println("Connected to the hr websocket endpoint...");
		Listener.super.onOpen(webSocket);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.err.println("New event has arrived: %s".formatted(data));
		return Listener.super.onText(webSocket, data, last);
	}

	@Override
	public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
		System.err.println("Disconnected from the hr websocket endpoint...");
		return Listener.super.onClose(webSocket, statusCode, reason);
	}

	@Override
	public void onError(WebSocket webSocket, Throwable error) {
		System.err.println("An error has occured: %s".formatted(error.getMessage()));
		Listener.super.onError(webSocket, error);
	}
	
}