package com.mecury.boot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mecury.boot.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/9-19:59
 * @Description:
 * @return:
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class KennyController {
   @Autowired
   ConfigBean configBean;
   @RequestMapping(value = "/kenny")
   public String index() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      String json =mapper.writeValueAsString(configBean);
      return  json;
   }
}
