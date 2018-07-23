package com.mercury.mq.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-15:21
 * @Description:
 * @return:
 */
@Component
public class MyMessage  implements Serializable {
   private static final long serialVersionUID = 1L;

   @Getter
   @Setter
   private String text;

}
