package com.mercury.springbootcache.callback;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/16-19:32
 * @Description:
 * @return:
 */
public class Li {
   public void executeMessage(Callback callback, String question) {
	  System.out.println("question: " +question);
	  for (int i = 0; i <3000 ; i++) {

	  }
	  String result=" 答案是2";
	  callback.resolve(result);
   }
}
