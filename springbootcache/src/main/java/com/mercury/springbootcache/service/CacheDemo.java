package com.mercury.springbootcache.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mercury.springbootcache.entity.Book;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/16-11:38
 * @Description:
 * @return:
 */
@Component
public class CacheDemo {
   public void test() throws ExecutionException, InterruptedException {
	  LoadingCache<Integer,Book> bookCache = CacheBuilder.newBuilder()
		  .concurrencyLevel(8)
		  .expireAfterWrite(5, TimeUnit.MINUTES)
		  .initialCapacity(10)
		  .maximumSize(10)
		  .recordStats()
		  .removalListener(notification -> System.out.println(notification.getKey() +
			  " was removed, cause is " + notification.getCause()))
		  .build(new CacheLoader<Integer, Book>() {
			 @Override
			 public Book load(Integer key) throws Exception {
				System.out.println("load student " + key);
				Book book = new Book();
				book.setId(key);
				book.setIsbn("178283930");
				book.setTitle("从入门到放弃系列");
				return  book;
			 }
		  });
	  System.out.println(bookCache.size());
	  for (int i = 0; i <20 ; i++) {
		 Book book =bookCache.get(i);
		 System.out.println(book);
		 TimeUnit.SECONDS.sleep(1);
	  }
	  System.out.println("Cache status:");
	  System.out.println(bookCache.stats().toString());

   }

}
