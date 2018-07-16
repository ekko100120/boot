package com.mercury.sql.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Book {
    private String isbn;
    private String title;

    public static void main(String[] args) {
        log.error("message");
    }
}
