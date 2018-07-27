package com.mercury.mq.subscribe.Entity;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-15:08
 * @Description:
 * @return:
 */
public interface IMessage {
   default  String getName(){
      return this.getClass().getName();
   }
}
