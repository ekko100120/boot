package com.mecury.boot.service.impl;

import com.mecury.boot.dao.IAccountDAO;
import com.mecury.boot.entity.Account;
import com.mecury.boot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/10-11:47
 * @Description:
 * @return:
 */
@Service
public class AccountServiceImple implements IAccountService{
   @Autowired
   IAccountDAO accountDAO;
   @Override
   public int add(Account account) {
	  return accountDAO.add(account);
   }

   @Override
   public int update(Account account) {
	  return accountDAO.update(account);
   }

   @Override
   public int delete(int id) {
	  return accountDAO.delete(id);
   }

   @Override
   public Account findAccountById(int id) {
	  return accountDAO.findAccountById(id);
   }

   @Override
   public List<Account> findAccountList() {
	  return accountDAO.findAccountList();
   }
}
