package com.mecury.boot;

import com.mecury.boot.entity.ConfigBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context){
	   return  args->{
		  System.out.println(" begin to inspect beans provided by spring boot:");
		  String[] beanNames =context.getBeanDefinitionNames();
		  Arrays.sort(beanNames);
		  Arrays.stream(beanNames).forEach(
			  (name)-> System.out.println(name)
		  );

	   };
	}
}
