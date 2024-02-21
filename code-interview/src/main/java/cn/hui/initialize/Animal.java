package cn.hui.initialize;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Name: Animal
 * Package: cn.hui.initialize
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/02/21 - 15:52
 * @Version: v1.0
 */

@Component
public class Animal implements InitializingBean, DisposableBean {
    // PostConstructor, PreDestroy, 提供初始化方法和销毁方法的
    @PostConstruct
    public void initMethod() {
        System.out.println("Animal...initMethod");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Animal...destroyMethod");
    }
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
