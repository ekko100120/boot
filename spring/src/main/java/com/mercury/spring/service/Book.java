package com.mercury.spring.service;

import org.springframework.cache.annotation.Cacheable;

public class Book {
    @Cacheable(value = { "sampleCache" })
    public String getBook(int id) {
        System.out.println("Method executed..");
        if (id == 1) {
            return "Book 1";
        } else {
            return "Book 2";
        }
    }
}
