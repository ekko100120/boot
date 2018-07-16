package com.mercury.sql.cache.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    @Getter @Setter private int id;
    @Getter @Setter private String isbn;
    @Getter @Setter private String title;


}
