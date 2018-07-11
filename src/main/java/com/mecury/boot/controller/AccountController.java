package com.mecury.boot.controller;

import com.mecury.boot.entity.Account;
import com.mecury.boot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @param : RestApi
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/10-11:50
 * @Description:
 * @return:
 */
@RestController
@RequestMapping("/account")
public class AccountController {
   @Autowired
   IAccountService accountService;

   @RequestMapping(value = "/list",method = RequestMethod.GET)
   public List<Account> getAccounts(){
      return accountService.findAccountList();
   }
   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
   public  Account getAccountById(@PathVariable("id") int id){
	  return accountService.findAccountById(id);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public String updateAccount(@PathVariable("id") int id,
							   @RequestParam(value="name",required = true) String name,
							   @RequestParam(value = "money",required = true) double money){
      Account account = new Account();
      account.setId(id);
      account.setMoney(money);
      account.setName(name);
	  System.err.println("message: "+ "id:"+id+",name:"+name+";money:"+money);
	  int t =accountService.update(account);
      if (t==1){
         return  account.toString();
	  }else{
         return  "fail";
	  }
   }
   @RequestMapping(value = "",method = RequestMethod.POST)
   public String postAccount(@RequestParam(value = "name") String name,
							 @RequestParam(value = "money") double money){
	  System.err.println("message: "+ "name:"+name+";money:"+money);
	  Account account = new Account();
      account.setName(name);
      account.setMoney(money);
      int t = accountService.add(account);
      if (t==1){
         return  account.toString();
	  }else{
         return "fail";
	  }

   }
}
