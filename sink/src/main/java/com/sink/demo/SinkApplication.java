package com.sink.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.demo")
public class SinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}

}
