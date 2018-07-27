package com.mercury.mq.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-13:18
 * @Description:
 * @return:
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.mercury.mq.subscribe")
public class Application  {

   public static void main(String[] args) {

	  SpringApplication.run(com.mercury.mq.subscribe.Application.class,args);
   }


}