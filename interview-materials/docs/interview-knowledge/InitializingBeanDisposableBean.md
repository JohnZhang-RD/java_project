## InitializingBean/DisposableBean

- 初始化接口，当Bean被实例化好后，会回调里面的函数，经常用于做一些加载资源的工作
- 销毁接口，当Bean被销毁之前，会回调里面的函数，经常用于做一些释放资源的工作

```java
@Component
public class Animal implements InitializingBean, DisposableBean {
    // 销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Animal...destroy");
    }

    // 初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Animal...afterPropertiesSet");
    }
}
```