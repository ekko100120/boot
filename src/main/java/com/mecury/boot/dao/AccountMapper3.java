package com.mecury.boot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-11:19
 * @Description:
 * @return:
 */
@Mapper
@Component
public interface AccountMapper3 {
   @Update("update account set money = #{money} where id = #{id}")
   int update(@Param("money") double money, @Param("id") int id);
}
