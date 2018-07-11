package com.mecury.boot.controller.mapper;

import com.mecury.boot.entity.Account;
import com.mecury.boot.service.AccountService;
import com.mecury.boot.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-10:51
 * @Description:
 * @return:
 */
@RestController
@RequestMapping("/demo/account")
public class AccountController2 {
   @Autowired
   AccountService accountService;
   @Autowired
   AccountService2 accountService2;

   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public List<Account> getAccounts() {
	  return accountService.findAccountList();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Account getAccountById(@PathVariable("id") int id) {
      accountService2.transfer();
	  return accountService.findAccount(id);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
							   @RequestParam(value = "money", required = true) double money) {
	  int t= accountService.update(name,money,id);
	  if(t==1) {
		 return "success";
	  }else {
		 return "fail";
	  }

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public String delete(@PathVariable(value = "id")int id) {
	  int t= accountService.delete(id);
	  if(t==1) {
		 return "success";
	  }else {
		 return "fail";
	  }

   }

   @RequestMapping(value = "", method = RequestMethod.POST)
   public String postAccount(@RequestParam(value = "name") String name,
							 @RequestParam(value = "money") double money) {

	  int t= accountService.add(name,money);
	  if(t==1) {
		 return "success";
	  }else {
		 return "fail";
	  }
   }
}
