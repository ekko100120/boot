package com.mercury.sql.cache.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter @Setter private int id;
    @Getter @Setter private String isbn;
    @Getter @Setter private String title;


}
