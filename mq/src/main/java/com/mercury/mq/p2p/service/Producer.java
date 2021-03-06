package com.mercury.mq.p2p.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-15:17
 * @Description:
 * @return:
 */
@Data
@Component
public class Producer  {
   @Autowired
   private JmsTemplate template;

   @Autowired
   @Qualifier(value = "queue")
   private javax.jms.Destination destination;

   public void produce(MyMessage message){
      template.convertAndSend(destination,message);
   }

}
