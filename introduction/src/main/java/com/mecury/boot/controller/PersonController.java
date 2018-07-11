package com.mecury.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/9-19:05
 * @Description:
 * @return:
 */
@RestController
public class PersonController {

   @Value("${person.name}")
   private String name;
   @Value("${person.age}")
   private int age;
   @RequestMapping(value = "/person")
   public String person(){
      return name+":"+age;
   }
}
