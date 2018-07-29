package com.mecury.boot.controller.interceptor;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface AuthValidator {

    boolean check() default false;
    String name() default "kenny";
}
