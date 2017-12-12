package com.dyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 使能Eureka Server服务
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
