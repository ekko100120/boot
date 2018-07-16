package com.mercury.springbootcache.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/16-18:20
 * @Description:
 * @return:
 */
public class CacheBuildDemo<K,T> {
   private K var;

   public K getVar() {
	  return var;
   }

   public void setVar(K var) {
	  this.var = var;
   }

   //Guava Cache 两种创建方式:
//   1. CacheLoader ：针对整个cache定义，根据统一的key值load value
//   2. Callable Callback ：根据callable接口 灵活自定义每个Entity
//   CacheLoader：在build cache的时候定义一个CacheLoader来获取数据，适用的情况：有固定的方式可以根据key来加载或计算value的值，比如从数据库中获取数据
//   Callable：在get的时候传入一个Callable对象，适用的情况：如果从缓存中获取不到数据，则另外计算一个出来，并把计算结果加入到缓存中
   public void TestCacheLoader(){
	  LoadingCache<K,T> cacheBuilder =CacheBuilder
		  .newBuilder()
		  .expireAfterWrite(1, TimeUnit.MINUTES)
		  .maximumSize(10)
		  .recordStats()
		  .removalListener(notification -> System.out.println(notification.getKey()
		  +"was expired, cause is "+notification.getCause()))
		  .build(new CacheLoader<K, T>() {
			 @Override
			 public T load(K key) throws Exception {
				return null;
			 }
		  });


   }

   public void TestCallable() throws ExecutionException {

	  Cache<K,T> cache = CacheBuilder.newBuilder()
		  .maximumSize(10)
		  .expireAfterWrite(1,TimeUnit.MINUTES)
		  .recordStats()
		  .removalListener(notification -> System.out.println(notification.getKey()
			  +"was expired, cause is "+notification.getCause()))
		  .build();

	  T value = cache.get( var, new Callable<T>() {
		 @Override
		 public T call() throws Exception {
			return null;
		 }
	  });
   }
}
