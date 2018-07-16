package com.mercury.sql.cache.AppRunner;


import com.mercury.sql.cache.dao.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-17:24
 * @Description:
 * @return:
 */
@Slf4j
@Component
public class AppRunner implements CommandLineRunner{

   private static final Logger logger = LoggerFactory.getLogger(AppRunner.class) ;
   private final BookRepository bookRepository;

   public AppRunner(BookRepository bookRepository) {
	  this.bookRepository = bookRepository;
   }

   @Override
   public void run(String... args) throws Exception {
      logger.info("=================== fetching books=================");
      logger.info("isbn-1234-->"+bookRepository.getByIsbn("isbn-1234"));
	  logger.info("isbn-4567-->"+bookRepository.getByIsbn("isbn-4567"));
	  logger.info("isbn-1234-->"+bookRepository.getByIsbn("isbn-1234"));
	  logger.info("isbn-4567-->"+bookRepository.getByIsbn("isbn-4567"));
	  logger.info("isbn-1234-->"+bookRepository.getByIsbn("isbn-1234"));
	  logger.info("isbn-4567-->"+bookRepository.getByIsbn("isbn-4567"));
   }
}
