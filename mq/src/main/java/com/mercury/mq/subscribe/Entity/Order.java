package com.mercury.mq.subscribe.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-14:49
 * @Description:
 * @return:
 */

@Getter
@Setter
@ToString
@Component(value = "orderMessage")
public class Order implements Serializable,IMessage {
   private static final long serialVersionUID = 1L;

   private int id;
   private String name;


}
