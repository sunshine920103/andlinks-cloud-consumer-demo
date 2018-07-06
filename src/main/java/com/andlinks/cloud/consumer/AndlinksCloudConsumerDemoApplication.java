package com.andlinks.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker                  // 通过该注解增加/actuator/hystrix.stream监控
@EnableHystrixDashboard
public class AndlinksCloudConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndlinksCloudConsumerDemoApplication.class, args);
	}
}
