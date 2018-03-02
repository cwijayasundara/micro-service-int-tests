package com.cham.twitterconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TwitterConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TwitterConsumerApplication.class, args);
	}
}
