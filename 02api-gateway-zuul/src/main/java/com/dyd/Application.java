package com.dyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 使能API网关
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
