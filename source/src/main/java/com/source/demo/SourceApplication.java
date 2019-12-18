package com.source.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.demo")
public class SourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourceApplication.class, args);
	}

}
