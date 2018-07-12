package com.mercury.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mercury.upload")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
