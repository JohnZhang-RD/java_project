## ApplicationListener

​		监听容器发布的事件, 允许程序员执行自己的代码,完成事件驱动开发, 它可以监听容器初始化完成、初始化失败等事件. 通常情况下可以使用监听器加载资源,开启定时任务等

```
使用
	1. 自定义类，实现ApplicationListener类
	2. 在META-INF/spring.factories配置文件中配置自定义的类
```
```java
public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // ApplicationEvent event 对应的是发布的事件, ApplicationReadyEvent,ApplicationFailedEvent
        if (event instanceof ApplicationReadyEvent) {
            // 容器初始化成功
            System.out.println("容器初始化成功");
        }
        if (event instanceof ApplicationFailedEvent) {
            // 容器初始化失败
            System.out.println("容器初始化失败");
        }
    }
}
```

这是一个实现了 `ApplicationListener` 接口的监听器类，用于在应用程序中监听特定事件的发生。下面是对这段代码的详细解释：

1. `MyListener` 类声明了实现 `ApplicationListener` 接口，表明这是一个用于监听应用事件的类。

2. `onApplicationEvent` 方法是接口中定义的方法，用于处理特定类型的应用事件。在这个方法中，通过判断事件的类型，执行相应的逻辑。

3. `ApplicationEvent` 是事件的基本类型，表示所有应用事件的父类。在这里，通过判断事件是否是 `ApplicationReadyEvent` 或 `ApplicationFailedEvent` 类型的，来分别处理容器初始化成功和失败的情况。

4. 如果事件是 `ApplicationReadyEvent`，则打印输出 "容器初始化成功"，表示应用容器初始化成功。

5. 如果事件是 `ApplicationFailedEvent`，则打印输出 "容器初始化失败"，表示应用容器初始化失败。

总体来说，这个监听器的主要作用是在应用程序中监听容器初始化成功和失败的事件，然后分别执行相应的逻辑。这样可以在应用启动过程中获取关键的初始化状态，进行相应的处理或记录日志。

问：
1. onApplicationEvent方法什么时候执行？
    - IOC容器发布事件之后执行，通常用于资源加载，定时任务发布等。