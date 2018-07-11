package com.mercury.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = "com.mercury")
@RestController
public class DockerApplication {

    @GetMapping("/docker")
    public String index(){
        return "docker demo";
    }
    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class);
    }

}
