package com.mercury.controller;

import com.mercury.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Map;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-11:56
 * @Description:
 * @return:
 */

@RestController
@RequestMapping("/api")
public class RestedController {

   @Autowired
   Account account;
   @RequestMapping(value = "/account",method = RequestMethod.GET)
   public Map<String ,Object> greeting(){
      return Collections.singletonMap("message",account);
   }
   @RequestMapping("/")
   public String index(){
      return  "rest api";
   }
}
