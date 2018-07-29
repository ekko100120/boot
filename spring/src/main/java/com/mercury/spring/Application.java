package com.mercury.spring;


import com.mercury.spring.configuration.BeanConfig;
import com.mercury.spring.configuration.CacheConfig;
import com.mercury.spring.entity.Company;
import com.mercury.spring.service.Book;
import com.mercury.spring.service.Computer;
import com.mercury.spring.service.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Spring Module 是 spring 基础demo
// 因为更喜欢Java Config 模式，所以以下都是基于 java Config + AnnotationConfigApplicationContext的扩展

@Slf4j
public class Application {

    public static void main(String[] args) {

        // 最基本的方式
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CacheConfig.class);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //动态加载configuration
        context.register(BeanConfig.class, CacheConfig.class);
        context.register(Computer.class);
        context.scan("com.mercury.spring");
        context.refresh();
        Book book =context.getBean(Book.class);
        Person person = (Person) context.getBean("person");
        person.setId(1);
        person.setName("kenny");
        log.info(person.toString());
        log.info(book.getBook(1));
        log.info("--------------------------------------");
        log.info(book.getBook(1));
        log.info(book.getBook(2));
        log.info("--------------------------------------");
        Computer computer = context.getBean(Computer.class);
        computer.setId(1);
        computer.setName("Apple MacPro");
        computer.setPrice(15000);
        log.info(computer.toString());
        log.info("--------------------------------------");
        Company company = context.getBean(Company.class);

        log.info(company.toString());
    }
}
