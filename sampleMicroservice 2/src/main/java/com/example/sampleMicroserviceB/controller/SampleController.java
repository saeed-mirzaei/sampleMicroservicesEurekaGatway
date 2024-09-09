package com.example.sampleMicroserviceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microserviceB/")
public class SampleController {

    @GetMapping("hello")
    public String hello(){
        return "hello from microservice - BBBB";
    }
}
