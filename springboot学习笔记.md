##springboot学习笔记;

*****
#### 1.Springboot配置文件详解;
两种类型的配置文件;

 * application.properties
 * application.yml
 
1. `.properties`文件是java的默认配置文件, 
2. `.yml`对应的事YAML类型,不支持`@PropertySource`注解加载配置(以前的版本，现在不知道)，将属性按顺序加载到内存中
3. `@Value` 读取配置文件的数据：`@Value("${数据名}")`
4.  `yml`文件中`${random.int}`,`${random.uuid}`,`${random.int(10)}` //用于生产随机数
5. `@ConfigurationProperties(prefix = "数据名")`将配置文件属性赋值给javabean
6. `@EnableConfigurationProperties` ConfigurationProperties注解的开关.
```yaml
my:
 name: forezp
 age: 12
 number:  ${random.int}
 uuid : ${random.uuid}
 max: ${random.int(10)}
 value: ${random.value}
 greeting: hi,i'm  ${my.name}
```
```java

@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean {

    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;

   
```
7. `@PropertySource(value = "classpath:test.properties")`自定义配置文件.