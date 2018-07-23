package com.mercury.mq;

import com.mercury.mq.service.MyMessage;
import com.mercury.mq.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-23:58
 * @Description:
 * @return:
 */
@Component
public class AppRunner implements CommandLineRunner {

   @Autowired
   private Producer producer;
   @Autowired
   private MyMessage myMessage;

   @Override
   public void run(String... args) throws Exception {
	  for (int i = 0; i <20 ; i++) {
		 myMessage.setText("第"+i+"条消息");
		 producer.produce(myMessage);
	  }
   }
}
