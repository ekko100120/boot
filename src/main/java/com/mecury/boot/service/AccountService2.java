package com.mecury.boot.service;

import com.mecury.boot.dao.AccountMapper3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-11:23
 * @Description:
 * @return:
 */
@Service
public class AccountService2 {

   @Autowired
   AccountMapper3 accountMapper3;

   @Transactional
   public void transfer() throws  RuntimeException{
      accountMapper3.update(90,1);
      accountMapper3.update(110,2);
   }
}
