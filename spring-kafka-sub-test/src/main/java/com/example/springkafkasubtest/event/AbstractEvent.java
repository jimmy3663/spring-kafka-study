package com.example.springkafkasubtest.event;

public abstract class AbstractEvent {
	private String eventType;

	public AbstractEvent() {
		this.eventType = this.getClass().getName();
	}
}
