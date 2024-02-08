package com.example.springkafkatestpubtest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springkafkatestpubtest.model.dto.SaveUserRequest;
import com.example.springkafkatestpubtest.model.dto.UpdateUserRequest;
import com.example.springkafkatestpubtest.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping(value = "")
	public void saveUser(@RequestBody SaveUserRequest request) {

		this.userService.saveUser(request.getName(), request.getAge());
	}

	@PostMapping(value = "/exceptions")
	public void saveUserWithException(@RequestBody SaveUserRequest request) {

		this.userService.saveUserWithException(request.getName(), request.getAge());
	}

	@PutMapping(value = "/{userId}")
	public void updateUser(@PathVariable Long userId,
		@RequestBody UpdateUserRequest request) {

		this.userService.updateUser(userId, request.getName(), request.getAge());
	}

}
