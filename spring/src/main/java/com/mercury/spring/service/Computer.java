package com.mercury.spring.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Computer {

    private int id;
    private int price;
    private String name;
}
