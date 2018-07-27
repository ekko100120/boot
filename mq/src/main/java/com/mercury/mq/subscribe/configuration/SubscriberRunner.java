package com.mercury.mq.subscribe.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-13:24
 * @Description:
 * @return:
 */
@Slf4j
@Component
@Order(3)
public class SubscriberRunner implements CommandLineRunner {
   @Override
   public void run(String... args) throws Exception {
	  log.info("------start config ActiveMQ Subscriber--------- ");
   }
}
