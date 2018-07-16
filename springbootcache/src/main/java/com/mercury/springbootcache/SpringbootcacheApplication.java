package com.mercury.springbootcache;

import com.mercury.springbootcache.callback.Callback;
import com.mercury.springbootcache.callback.Li;
import com.mercury.springbootcache.callback.Wang;
import com.mercury.springbootcache.service.CacheDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class SpringbootcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(CacheDemo cacheDemo) throws ExecutionException, InterruptedException {
	  return (args -> {
	     Li li = new Li();
	     Wang wang = new Wang(li);
	     wang.askQuestion("你是傻逼么");
		 cacheDemo.test();
	  });
   }

   @Bean
   public Li newInstance(){
	   return  new Li();
   }
}
