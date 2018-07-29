package com.mercury.spring.service;


import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

@Data
public class Person {

    private int id;
    private String name;

}
