package com.mercury.springbootcache.dao;

import com.mercury.springbootcache.entity.Book;

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
