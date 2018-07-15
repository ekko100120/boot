package com.mercury.upload.controller;

import com.mercury.upload.Entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//提交表单
@Controller
@RequestMapping("greeting")
public class GreetingController {

    public  void  model(long id,String context, Model model){
       model.addAttribute("greeting",new Greeting(id,context)) ;
    }

    @GetMapping(value = "/greeting")
    public String greeting(Model model){
        System.err.println("get greeting method");
        model.addAttribute("greeting", new Greeting());
        return "greetings";
    }

    @PostMapping(value = "/greeting")
    public String greeting(@ModelAttribute(value = "out") Greeting greeting){
        System.err.println("post greeting method");
        return  "output";
    }
}
