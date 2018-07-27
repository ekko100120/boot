package com.mercury.mq.subscribe.service;

import com.mercury.mq.subscribe.Entity.IMessage;
import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-14:28
 * @Description:
 * @return:
 */
@Component
public class Publisher {

   @Autowired
   private JmsTemplate jmsTemplate;

   @Autowired
   @Qualifier(value = "topic")
   private ActiveMQDestination destination;

   public void publish(IMessage message){
      jmsTemplate.convertAndSend(destination,message);
   }
}
