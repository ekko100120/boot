package com.mercury.sql.cache.AppRunner;


import com.mercury.sql.cache.dao.BookRepository;
import com.mercury.sql.cache.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-17:24
 * @Description:
 * @return:
 */
@Slf4j
@Component
public class AppRunner implements CommandLineRunner{

   private static final Logger logger = LoggerFactory.getLogger(AppRunner.class) ;
   private final BookRepository bookRepository;
   @Autowired
    private StringRedisTemplate stringRedisTemplate;
   @Autowired
   private RedisTemplate<String,Serializable> redisTemplate;


   public AppRunner(BookRepository bookRepository) {
	  this.bookRepository = bookRepository;
   }

    @Override
    public void run(String... args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        IntStream.range(1,100).forEach(i->{
            service.execute(()->stringRedisTemplate.opsForValue().increment("kk",1));
        });
        stringRedisTemplate.opsForValue().set("k1","v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果是：]-[{}]",k1);
        String key = "battcn:book:1";
        redisTemplate.opsForValue().set(key,new Book(1,"u1","pa"));
        final Book book = (Book) redisTemplate.opsForValue().get(key);
        log.info("[对象缓存结果]-[{}]",book);
        service.shutdown();
    }

//   @Override
//   public void run(String... args) throws Exception {
//      logger.info("=================== fetching books=================");
//      logger.info("isbn-1234-->"+bookRepository.getByIsbn("isbn-1234"));
//	  logger.info("isbn-4567-->"+bookRepository.getByIsbn("isbn-4567"));
//	  logger.info("isbn-1234-->"+bookRepository.getByIsbn("isbn-1234"));
//	  logger.info("isbn-4567-->"+bookRepository.getByIsbn("isbn-4567"));
//	  logger.info("isbn-1234-->"+bookRepository.getByIsbn("isbn-1234"));
//	  logger.info("isbn-4567-->"+bookRepository.getByIsbn("isbn-4567"));
//   }


}
