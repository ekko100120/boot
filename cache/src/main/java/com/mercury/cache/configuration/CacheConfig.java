package com.mercury.cache.configuration;

import com.mercury.cache.service.Book;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@Configuration
@EnableCaching
@ImportResource("classpath:beans.xml")
public class CacheConfig {

    @Bean
    public Book book(){
        return  new Book();
    }

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("sampleCache")));
        return cacheManager;
    }
}
