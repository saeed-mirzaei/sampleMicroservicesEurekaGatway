package com.example.sampleMicroservice.service;

import com.example.sampleMicroservice.client.MicroserviceBClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
    private final MicroserviceBClient microserviceBClient;
    private EurekaClient eurekaClient;

    public SampleService(MicroserviceBClient microserviceBClient) {
        this.microserviceBClient = microserviceBClient;
    }

    public String callB() {
        return microserviceBClient.helloMicroserviceB();
    }
}
