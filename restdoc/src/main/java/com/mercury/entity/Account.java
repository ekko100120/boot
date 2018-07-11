package com.mercury.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-12:31
 * @Description:
 * @return:
 */
@Component
public class Account {
   @Value(value = "${account.id}")
   private int id;
   @Value(value = "${account.name}")
   private String name;
   @Value(value = "${account.money}")
   private  double money;

   public int getId() {
	  return id;
   }

   public void setId(int id) {
	  this.id = id;
   }

   public String getName() {
	  return name;
   }

   public void setName(String name) {
	  this.name = name;
   }

   public double getMoney() {
	  return money;
   }

   public void setMoney(double money) {
	  this.money = money;
   }

   @Override
   public String toString() {
	  return "Account{" +
		  "id=" + id +
		  ", name='" + name + '\'' +
		  ", money=" + money +
		  '}';
   }
}
