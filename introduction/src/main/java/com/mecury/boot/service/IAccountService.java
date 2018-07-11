package com.mecury.boot.service;

import com.mecury.boot.entity.Account;

import java.util.List;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/10-11:46
 * @Description:
 * @return:
 */
public interface IAccountService {
   int add(Account account);

   int update(Account account);

   int delete(int id);

   Account findAccountById(int id);

   List<Account> findAccountList();

}
