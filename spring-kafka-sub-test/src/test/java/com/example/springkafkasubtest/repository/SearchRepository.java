package com.example.springkafkasubtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkafkasubtest.entity.Search;

public interface SearchRepository extends JpaRepository<Search, Long> {
}
