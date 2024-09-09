package com.example.sampleMicroservice.client;

import com.example.sampleMicroservice.config.CustomErrorHandling;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sample-microservice-b", fallback = CustomErrorHandling.class)
public interface MicroserviceBClient {

    @GetMapping("/microserviceB/hello")
    String helloMicroserviceB();
}
