package com.mercury.mq.p2p;

import com.mercury.mq.p2p.service.MyMessage;
import com.mercury.mq.p2p.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-10:43
 * @Description:
 * @return:
 */
@Component
@Order(2)
public class ProducerRunner implements CommandLineRunner {
   @Autowired
   private Producer producer;
   @Autowired
   private MyMessage myMessage;

   @Override
   public void run(String... args) throws Exception {
	  for (int i = 0; i <20 ; i++) {
		 myMessage.setText("第"+i+"条消息");
		 System.out.println(myMessage.getText());
		 producer.produce(myMessage);
	  }
   }
}
