package com.mercury.springbootcache.dao;

import com.mercury.springbootcache.entity.Book;
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
   public Book getByIsbn(String isbn) {
	  simulateSlowService();
	  return  new Book(1,isbn,"some book");
   }

   private void simulateSlowService() {
      long time =3000L;
	  try {
		 Thread.sleep(5L);
	  } catch (InterruptedException e) {
		 e.printStackTrace();
	  }
   }
}
