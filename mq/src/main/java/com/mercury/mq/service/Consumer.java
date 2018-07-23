package com.mercury.mq.service;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-15:20
 * @Description:
 * @return:
 */
@Data
@Component
public class Consumer {
   private int id;

   public void consume(MyMessage message){
      System.out.println("consumer: "+id +" consuming "+ message);
   }

}
