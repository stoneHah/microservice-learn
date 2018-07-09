package com.zq.learn.energyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnergyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyServiceApplication.class, args);
	}
}
