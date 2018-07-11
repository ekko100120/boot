package com.mercury.springbootcache.entity;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-17:13
 * @Description:
 * @return:
 */
public class Book {
   private String isbn;
   private String title;

   public Book(String isbn, String title) {
	  this.isbn = isbn;
	  this.title = title;
   }

   public String getIsbn() {
	  return isbn;
   }

   public void setIsbn(String isbn) {
	  this.isbn = isbn;
   }

   public String getTitle() {
	  return title;
   }

   public void setTitle(String title) {
	  this.title = title;
   }

   @Override
   public String toString() {
	  return "Book{" +
		  "isbn='" + isbn + '\'' +
		  ", title='" + title + '\'' +
		  '}';
   }
}
