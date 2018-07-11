package com.zq.learn.userservice;

import com.zq.learn.userservice.common.ExcludeGlobalScan;
import com.zq.learn.userservice.common.MyBean;
import com.zq.learn.userservice.service.IFileUploadService;
import com.zq.learn.userservice.service.impl.FileUploadServiceImpl;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(excludeFilters = {
		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class),
		@Filter(type = FilterType.ANNOTATION, classes = ExcludeGlobalScan.class)})
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	@MyBean
	public IFileUploadService localFileUploadService(){
		return new FileUploadServiceImpl();
	}

	@Bean
	public IFileUploadService ossFileUploadService(){
		return new FileUploadServiceImpl();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(UserServiceApplication.class);
 	   	app.run(args);
	}


}
