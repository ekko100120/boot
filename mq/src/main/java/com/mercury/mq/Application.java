package com.mercury.mq;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;



@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.mercury.mq")
@EnableCaching

public class Application implements CommandLineRunner {


   private ActivemqConfiguration configuration;
   public static void main(String[] args) {

	  SpringApplication.run(Application.class,args);
   }


   @Override
   public void run(String... args) throws Exception {

   }
}