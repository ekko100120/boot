package com.mercury.cache;

import com.mercury.cache.configuration.CacheConfig;
import com.mercury.cache.service.Book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CacheConfig.class);
        Book book =context.getBean(Book.class);

        log.info(book.getBook(1));
        log.info("--------------------------------------");
        log.info(book.getBook(1));
        log.info(book.getBook(2));
    }
}
