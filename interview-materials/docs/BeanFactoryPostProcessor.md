## BeanFactoryPostProcessor

- Bean工厂后置处理器，当BeanFactory准备好了后(Bean初始化之前)，会调用该接口的postProcessBeanFactory方法，经常用于新增BeanDefinition

![](D:\repositories\interview-materials\docs\images\图片6.png)

| **实现类名**                              | **作用**                                  |
| ----------------------------------------- | ----------------------------------------- |
| ConfigurationClassPostProcessor           | 扫描启动类所在包下的注解                  |
| ServltComponentRegisteringPostProcessor   | 扫描@WebServlet、@WebFilter、@WebListener |
| CachingMetadataReaderFactoryPostProcessor | 配置ConfigurationClassPostProcessor       |
| ConfigurationWarningsPostProcessor        | 配置警告提示                              |