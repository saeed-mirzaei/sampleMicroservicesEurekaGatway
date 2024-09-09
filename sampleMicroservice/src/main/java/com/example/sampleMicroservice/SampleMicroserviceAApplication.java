package com.example.sampleMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.sampleMicroservice.client")
public class SampleMicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleMicroserviceAApplication.class, args);
	}

}
