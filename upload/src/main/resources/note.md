## Note

upload 模块主要分为两部分：
* 表单验证和提交
* fileload 文件上传

其中，表单验证和提交部分，一些重要的接口如下：
* `WebMvcConfigurer `接口:代码中通过此接口实现`addViewControllers`方法 ，将视图和url注册到`ViewControllerRegistry`
* `BindingResult`接口
* `ConstraintValidator`接口，实现自定义约束验证器，包含两个方法


注解类：
* @ModelAttribute

根据注解的位置可以分为以下几种类型：

总体上分为注解在方法上和注解在参数上

注解在方法上的功能概括起来是为了【存参】：让model获取url参数或者其他类型参数(post表格)

注解在参数的功能概括起来是为了【获取参数】：从model中根据key获取attrbute的vaule值
1. 应用在方法上。

    1.1 @ModelAttribute注解无返回值的方法[没有@RequstMapping]时，需要在方法中加入model参数，存储入参数据
    
    1.2 @ModelAttribute注解有返回值的方法[[没有@RequstMapping]]时，注解的value属性无key值，此时model中对应的key值为return的 值？？
    
    1.3 @ModelAttribute注解应用在方法[[有@RequstMapping]]上时，此时返回值对应的不是视图名，而是Model的key值，默认对应的视图名为URL名;
    【这里遇到一个小问题，当url是class+method时，对应找是两者拼接的视图名,eg:类注解为@RequstMapping("/class"),方法注解为@RequstMapping("/method"),此时对应的视图为"class/method"而不是"method"】

2. 应用在方法的参数上,主要是获取对应的key的ModelAttribute中的value值。

