package com.example.springkafkatestpubtest.event;

import com.example.springkafkatestpubtest.enums.UserEventType;

import lombok.Getter;

@Getter
public class UserEvent extends AbstractEvent {
	private UserEventType userEventType;
	private Long userId;
	private String name;
	private Integer age;

	public UserEvent() {
		super();
	}

	public static UserEvent ofCreate(
		Long userId,
		String name,
		Integer age
	) {
		UserEvent userEvent = new UserEvent();
		userEvent.userEventType = UserEventType.CREATE;
		userEvent.userId = userId;
		userEvent.name = name;
		userEvent.age = age;

		return userEvent;
	}
}
