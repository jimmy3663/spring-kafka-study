package com.example.springkafkatestpubtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import com.example.springkafkatestpubtest.service.TestService;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping(value = "/ping")
    public String pong() {
        return "pong";
    }

    @PostMapping(value = "/pub")
    public void pub(@RequestParam String message) {
        this.testService.pub(message);
    }
}
