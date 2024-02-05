package com.example.springkafkatestpubtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkafkatestpubtest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
