springboot Redis Cache 的几个步骤：

##### 1. 配置springboot配置文件，加入redis服务器连接池的相关配置：

**目前比较好的解决方法是Luttuce连接池方案**
```yaml
  # redis configuration
  # redis connect pool 分为 Jedis和Lettuce两种
  redis:
    database: 0
    host: localhost
    port: 6379
    password:
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        max-wait: -1ms
        min-idle: 0
```

##### 2. RedisCacheAutoConfiguation配置类

2.1 `@AutoConfigureAfter(RedisAutoConfiguration.class)`此注解完成了Redis的自动配置工作(连接池的构建，具体原理待看源码)

2.2 注入连接池 `LettuceConnectionFactory` bean
```java
  @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        return  new LettuceConnectionFactory();
    }
```
2.3 注入<String,String>类型的`StringRedisTemplate`,由于默认实现以存在，所以直接注入bean就行了

2.4 当需要其他类型的缓存时，需要自己实现`redisTemplate`.
```java
        @Bean
        public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory){
            RedisTemplate<String,Serializable> template = new RedisTemplate<>();
            template.setKeySerializer(new StringRedisSerializer());
            template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
            template.setConnectionFactory(redisConnectionFactory);
            return  template;
        }
```

##### 3. 注入template，获取连接，操作缓存数据;
```java
    @Override
    public void run(String... args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        IntStream.range(1,100).forEach(i->{
            service.execute(()->stringRedisTemplate.opsForValue().increment("kk",1));
        });
        stringRedisTemplate.opsForValue().set("k1","v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果是：]-[{}]",k1);
        String key = "battcn:book:1";
        redisTemplate.opsForValue().set(key,new Book(1,"u1","pa"));
        final Book book = (Book) redisTemplate.opsForValue().get(key);
        log.info("[对象缓存结果]-[{}]",book);
    }
```

