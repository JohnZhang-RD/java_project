## Aware

​	感知接口，Spring提供的一种机制，通过实现该接口，重写方法，可以感知Spring应用程序执行过程中的一些变化。Spring会判断当前的Bean有没有实现Aware接口，如果实现了，会在特定的时机回调接口对应的方法

| **子接口名**         | **作用**               |
| -------------------- | ---------------------- |
| BeanNameAware        | Bean名称的感知接口     |
| BeanClassLoaderAware | Bean类加载器的感知接口 |
| BeanFactoryAware     | Bean工厂的感知接口     |

```java
@Component
public class Student implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {
    // BeanClassLoader的回调方法
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Student...setBeanClassLoader" + classLoader);
    }

    // BeanFactoryAware的回调方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Student...setBeanFactory" + beanFactory);
    }

    // BeanName的回调方法
    @Override
    public void setBeanName(String name) {
        System.out.println("Student...setBeanName" + name);
    }
}
```