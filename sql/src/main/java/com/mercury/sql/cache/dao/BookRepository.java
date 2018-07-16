package com.mercury.sql.cache.dao;


import com.mercury.sql.cache.entity.Book;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-17:14
 * @Description:
 * @return:
 */
public interface BookRepository {

   Book getByIsbn(String isbn);
}
