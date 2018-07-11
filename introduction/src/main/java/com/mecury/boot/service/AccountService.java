package com.mecury.boot.service;

import com.mecury.boot.dao.AccountMapper;
import com.mecury.boot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-10:48
 * @Description:
 * @return:
 */
@Service
public class AccountService {

   @Autowired
   private AccountMapper accountMapper;

   public int add(String name, double money) {
	  return accountMapper.add(name, money);
   }
   public int update(String name, double money, int id) {
	  return accountMapper.update(name, money, id);
   }
   public int delete(int id) {
	  return accountMapper.delete(id);
   }
   public Account findAccount(int id) {
	  return accountMapper.findAccount(id);
   }
   public List<Account> findAccountList() {
	  return accountMapper.findAccountList();
   }
}
