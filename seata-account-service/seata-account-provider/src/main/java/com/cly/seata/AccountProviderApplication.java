package com.cly.seata;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDubbo
public class AccountProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountProviderApplication.class, args);
	}

}
