## BeanPostProcessor

- Bean的后置处理器，当Bean对象初始化之前以及初始化之后，会回调该接口对应的方法
  - postProcessBeforeInitialization:  Bean对象初始化之前调用
  - postProcessAfterInitialization:  Bean对象初始化之后调用

```java
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 初始化之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor...Before..." + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    // 初始化之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor...After..." + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }


}
```

| **实现类名**                         | **作用**                        |
| ------------------------------------ | ------------------------------- |
| AutowiredAnnotationBeanPostProcessor | 用来完成依赖注入                |
| AbstractAutoProxyCreator             | 用来完成代理对象的创建          |
| AbstractAdvisingBeanPostProcessor    | 将Aop中的通知作用于特定的Bean上 |