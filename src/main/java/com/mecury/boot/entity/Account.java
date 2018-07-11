package com.mecury.boot.entity;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/10-11:23
 * @Description:
 * @return:
 */
public class Account {
   private int id;
   private String name;
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
