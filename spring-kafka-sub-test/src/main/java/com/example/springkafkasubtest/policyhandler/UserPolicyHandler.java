package com.example.springkafkasubtest.policyhandler;

import org.springframework.stereotype.Service;

import com.example.springkafkasubtest.event.UserEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPolicyHandler {

	public void handleUserPolicy(UserEvent userEvent) {
		log.info("UserPolicyHandler: {}", userEvent);
	}

	public void handleUserPolicyWithException(UserEvent event) {
		log.info("UserPolicyHandlerWithException: {}", event);
		throw new RuntimeException("Exception on purpose!");
	}
}
