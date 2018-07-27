package com.mercury.mq.subscribe.configuration;

import com.mercury.mq.subscribe.Entity.IMessage;
import com.mercury.mq.subscribe.service.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-13:22
 * @Description:
 * @return:
 */
@Slf4j
@Component
@Order(2)
public class PublisherRunner implements CommandLineRunner {

   @Autowired
   private Publisher publisher;

   @Autowired
   private Destination destination;

   @Autowired
   @Qualifier(value = "orderMessage")
   private com.mercury.mq.subscribe.Entity.Order message;
   @Override
   public void run(String... args) throws Exception {
	  log.info("------start config ActiveMQ Publisher--------- ");
	  for (int i = 0; i < 1000000; i++) {
		 message.setId(i);
		 message.setName("[order"+i+"]");

		 publisher.publish(message);
	  }
   }
}
