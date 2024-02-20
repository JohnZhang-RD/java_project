package cn.hui.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Name: MyListener
 * Package: cn.hui.listener
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/02/20 - 20:35
 * @Version: v1.0
 */

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
