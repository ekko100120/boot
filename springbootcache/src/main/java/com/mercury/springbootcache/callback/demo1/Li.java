package com.mercury.springbootcache.callback.demo1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/16-19:32
 * @Description:
 * @return:
 */
@Component
public class Li {
   public void executeMessage(Callback callback, String question) throws InterruptedException {
	  System.out.println("question: " +question);
	   TimeUnit.SECONDS.sleep(10);
	  String result=" 答案是2";
	  callback.resolve(result);
   }
}
