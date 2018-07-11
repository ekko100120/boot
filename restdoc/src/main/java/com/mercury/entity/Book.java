package com.mercury.entity;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-16:20
 * @Description:
 * @return:
 */
public class Book {
   private long id;
   private String name;
   private  double price;

   public long getId() {
	  return id;
   }

   public void setId(long id) {
	  this.id = id;
   }

   public String getName() {
	  return name;
   }

   public void setName(String name) {
	  this.name = name;
   }

   public double getPrice() {
	  return price;
   }

   public void setPrice(double price) {
	  this.price = price;
   }
}
