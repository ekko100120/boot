package com.mercury.spring.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Company  {

    @Value("100")
    private int id;
    @Value("AliBaba")
    private String name;
    @Value("上海")
    private String location;
}
