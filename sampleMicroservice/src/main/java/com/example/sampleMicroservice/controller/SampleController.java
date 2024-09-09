package com.example.sampleMicroservice.controller;

import com.example.sampleMicroservice.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microserviceA/")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("hello")
    public String hello(){
        return "hello from microservice - A";
    }

    @GetMapping("callB")
    public String callB(){
        return sampleService.callB();
    }
}
