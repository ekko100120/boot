package com.mercury.mq.p2p;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.mercury.mq")

public class Application  {

   public static void main(String[] args) {

	  SpringApplication.run(Application.class,args);
   }


}