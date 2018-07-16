package com.mercury.sql.cache.dao;


import com.mercury.sql.cache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-17:14
 * @Description:
 * @return:
 */
@Repository
public class SimpleBookRepository implements  BookRepository{
   @Override
   @Cacheable("books")
   public Book getByIsbn(String isbn) {
	   try {
		   simulateSlowService();
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   }
	   return  new Book(1,isbn,"some book");
   }

   private void simulateSlowService() throws InterruptedException {
	   TimeUnit.SECONDS.sleep(5);
   }
}
