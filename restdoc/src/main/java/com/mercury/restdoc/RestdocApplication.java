package com.mercury.restdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mercury")
public class RestdocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestdocApplication.class, args);
	}
}
