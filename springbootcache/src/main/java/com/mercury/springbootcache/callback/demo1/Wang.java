package com.mercury.springbootcache.callback.demo1;

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
             try {
                 li.executeMessage(Wang.this,question);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
	  }).start();
      // play（）
	  play();
   }

   public void play() throws InterruptedException {
       System.out.println("play game ing+++++++++++");
	  TimeUnit.SECONDS.sleep(3);
   }
   @Override
   public void resolve(String result) {
	  System.out.println("result: "+result);
   }
}
