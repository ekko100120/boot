package com.mercury.upload.controller;

import com.mercury.upload.Entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@ModelAttribute参数功能演示

@Slf4j
@RequestMapping(value = "/attr")
@Controller
public class ModelAttrController {
    //有坑:当@ModelAttribute修饰非@RequestMapping方法时，Request请求会首先执行该方法，如果无参数会出现异常
    @RequestMapping(value = "/")
    public String index(){
        return "results";
    }

    @ModelAttribute
    public String myModel(long id , String nameString ){
        Greeting greeting = new Greeting(id, nameString);
        System.out.println("--------------------------------------------------------------");
        System.out.println(greeting.toString());
        String name = nameString;
        return name;
    }

//    @ModelAttribute("/greeting")
//    public Greeting myModel(long id , String context , Model model){
//        Greeting greeting = new Greeting(id, context);
//        System.out.println("--------------------------------------------------------------");
//        System.out.println(greeting.toString());
//        return greeting;
//    }

//    @GetMapping("/result")
//    public String greeting(@ModelAttribute("greeting") Greeting greeting){
//        return "output";
//    }

    public Greeting  newInstance(){
        return  new Greeting();
    }
    @GetMapping("/context")
    public String greeting(@ModelAttribute("context") String context){

        return "output";
    }
    @GetMapping("/output")
    @ModelAttribute("greeting")
    public Greeting greeting(@RequestParam long id, @RequestParam String context){
        Greeting greeting = new Greeting(id,context);

        return  greeting;
    }

}
