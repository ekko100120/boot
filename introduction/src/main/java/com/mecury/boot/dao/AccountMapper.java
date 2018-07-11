package com.mecury.boot.dao;

import com.mecury.boot.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-10:33
 * @Description:
 * @return:
 */
@Mapper
@Component
public interface AccountMapper {

   @Insert("insert into account(name,money) values(#{name},#{money})")
   int add(@Param("name") String name, @Param("money") double money);

   @Update("update account set name = #{name},money = #{money} where id = #{id}")
   int update( @Param("name") String name, @Param("money") double money, @Param("id") int id);

   @Delete("delete from account where id = #{id}")
   int delete(int id);

   @Select("select id,name as name, money as money from account where id = #{id}")
   Account findAccount(@Param("id") int id);

   @Select("select id, name as name,money as money from account")
   List<Account> findAccountList();
}
