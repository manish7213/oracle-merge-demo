package com.example.oraclemergedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oraclemergedemo.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test() {
    	testService.processData();
    }
}
