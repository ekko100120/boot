package com.mercury.springbootcache.callback;

import org.springframework.beans.factory.annotation.Autowired;
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
public class Wang implements Callback {

   private Li li;

   @Autowired
   public Wang(Li li) {
	  this.li = li;
   }

   public void askQuestion(final String question) throws InterruptedException {
      new Thread(new Runnable() {
		 @Override
		 public void run() {
			li.executeMessage(Wang.this,question);
		 }
	  }).start();

	  play();
   }

   public void play() throws InterruptedException {
	  TimeUnit.SECONDS.sleep(3);
   }
   @Override
   public void resolve(String result) {
	  System.out.println("result: "+result);
   }
}
