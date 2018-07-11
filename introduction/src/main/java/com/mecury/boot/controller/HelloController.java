package com.mecury.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/9-18:22
 * @Description:
 * @return:
 */

@RestController
public class HelloController {
   @RequestMapping("/hello")
   public String index(){
      return "greet from spring boot!";
   }
}
