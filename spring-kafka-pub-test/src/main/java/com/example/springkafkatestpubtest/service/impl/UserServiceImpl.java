package com.example.springkafkatestpubtest.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springkafkatestpubtest.entity.User;
import com.example.springkafkatestpubtest.event.UserEvent;
import com.example.springkafkatestpubtest.publisher.EventPublisher;
import com.example.springkafkatestpubtest.repository.UserRepository;
import com.example.springkafkatestpubtest.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final EventPublisher eventPublisher;

	@Override
	@Transactional
	public void saveUser(String name, Integer age) {
		User user = User.of(name, age);

		this.userRepository.save(user);

		this.eventPublisher.publish(UserEvent.ofCreate(
			user.getId(),
			user.getName(),
			user.getAge()
		));
	}

	/**
	 * Exception 발생 시 kafka rollback 테스트
	 *
	 * @param name
	 * @param age
	 */
	@Override
	@Transactional
	public void saveUserWithException(String name, Integer age) {

		User user = User.of(name, age);

		this.userRepository.save(user);

		this.eventPublisher.publish(UserEvent.ofCreate(
			user.getId(),
			user.getName(),
			user.getAge()
		));

		throw new RuntimeException("Exception on purpose!");
	}

	@Override
	@Transactional
	public void updateUser(Long id, String name, Integer age) {
		User user = this.userRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("User not found"));

		user.update(name, age);

		this.eventPublisher.publish(UserEvent.ofUpdate(
			user.getId(),
			user.getName(),
			user.getAge()
		));

		this.userRepository.save(user);
	}
}
