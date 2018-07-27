package com.mercury.mq.p2p.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-15:20
 * @Description:
 * @return:
 */
@Component
public class Consumer {

   @Getter
   @Setter
   private int id;

   public void consume(MyMessage message){
      System.out.println("consumer: "+id +" consuming "+ message.toString());
   }

}
