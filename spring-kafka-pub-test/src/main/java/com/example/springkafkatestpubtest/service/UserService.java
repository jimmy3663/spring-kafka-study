package com.example.springkafkatestpubtest.service;

public interface UserService {
	void saveUser(String name, Integer age);

	void saveUserWithException(String name, Integer age);
}
