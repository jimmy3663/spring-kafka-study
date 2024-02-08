package com.example.springkafkatestpubtest.event;

import lombok.Getter;

@Getter
public abstract class AbstractEvent {
	private String key;
	private String eventType;

	public AbstractEvent() {
		this.eventType = this.getClass().getSimpleName();
	}

	public AbstractEvent(String key) {
		this.key = key;
		this.eventType = this.getClass().getName();
	}
}
