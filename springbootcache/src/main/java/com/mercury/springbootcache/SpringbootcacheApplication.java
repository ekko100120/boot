package com.mercury.springbootcache;

import com.mercury.springbootcache.callback.demo1.Li;
import com.mercury.springbootcache.callback.demo1.Wang;
import com.mercury.springbootcache.callback.demo2.Client;
import com.mercury.springbootcache.callback.demo2.PrintFinishedCallBack;
import com.mercury.springbootcache.service.CacheDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class SpringbootcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(CacheDemo cacheDemo) throws ExecutionException, InterruptedException {
	  return (args -> {

		 cacheDemo.test();
	  });
   }


//   @Bean
//   public CommandLineRunner callbackTest1(Li li) throws InterruptedException {
//	  return (args -> {
//		  System.out.println("test callback interface");
//		  Wang wang = new Wang(li);
//		  wang.askQuestion("你是傻逼么");
//	  });
//   }
//	@Bean
//	public CommandLineRunner callbackTest2() throws InterruptedException {
//		return (args -> {
//			System.out.println("test callback interface 2================");
//			Client client = new Client();
//			PrintFinishedCallBack callBack = new PrintFinishedCallBack() {
//				@Override
//				public void printFinished(String msg) {
//					System.out.println("打印完的提示音："+ msg +"+++++++++++++++++");
//				}
//			};
//			System.out.println("打印机开机++++++++++++++++++");
//			client.gotoPrintSync(callBack,"同步回调接口");
//			System.out.println("打印机关机");
//
//		});
//	}

	@Bean
	public CommandLineRunner callbackTest3() throws InterruptedException {
		return (args -> {
			System.out.println("test callback interface 3：异步回调================");
			Client client = new Client();
			PrintFinishedCallBack callBack = new PrintFinishedCallBack() {
				@Override
				public void printFinished(String msg) {
					System.out.println("打印完的提示音:"+ msg+" ++++++++++++++");
				}
			};
			System.out.println("---------------------------------------------");
			System.out.println("打印机开机++++++++++++++++++");
			client.gotoPrintAsync(callBack,"异步回调接口");
			System.out.println("perple可以去玩手机了++++++++++++++++++++++++");
		});
	}
}
