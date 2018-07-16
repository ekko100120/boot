package com.mercury.springbootcache.entity;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-17:13
 * @Description:
 * @return:
 */
public class Book {
   private int id;
   private String isbn;
   private String title;

   public Book() {
   }

   public Book(int id,String isbn, String title) {
      this.id=id;
	  this.isbn = isbn;
	  this.title = title;
   }


   public String getIsbn() {
	  return isbn;
   }

   public void setIsbn(String isbn) {
	  this.isbn = isbn;
   }

   public int getId() {
	  return id;
   }

   public void setId(int id) {
	  this.id = id;
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
		  "id=" + id +
		  ", isbn='" + isbn + '\'' +
		  ", title='" + title + '\'' +
		  '}';
   }
}
