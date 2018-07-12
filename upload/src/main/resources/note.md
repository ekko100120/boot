## Note

upload 模块主要分为两部分：
* 表单验证和提交
* fileload 文件上传

其中，表单验证和提交部分，一些重要的接口如下：
* `WebMvcConfigurer `接口:代码中通过此接口实现`addViewControllers`方法 ，将视图和url注册到`ViewControllerRegistry`
* `BindingResult`接口
* `ConstraintValidator`接口，实现自定义约束验证器，包含两个方法