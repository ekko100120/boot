package com.mercury.mq.subscribe.service;

import com.mercury.mq.p2p.service.MyMessage;
import com.mercury.mq.subscribe.Entity.IMessage;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-14:51
 * @Description:
 * @return:
 */

@Component
@Data
public class Subcriber {

   private String name;

   public void subscribe(IMessage message){
	  System.out.println(name +" consuming "+ message.toString());
   }


}
