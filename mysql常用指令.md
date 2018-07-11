## mysql常用指令

*************
* mysql 5.7.6+ url ssl+Timezone+characterEncoding+useUnicode
```sbtshell
jdbc:mysql://localhost:3306/bank?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT
```
* 创建数据库;
```mysql
 create DATABASE bank;  # 创建数据库;
 
```
* 使用显示当前数据库;
```mysql
USE  bank; #使用bank数据库
SELECT  database(); # 显示当前数据库--方式1;

show tables;  # 输出数据的第一行有当前数据库信息;

 
```
* 删除数据库；
```mysql
    DROP TABLE  IF EXISTS `demo` # 注意demo的位置,mysql 在最后;
```