package com.example.springcloudsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSearchServiceApplication.class, args);
	}

}
