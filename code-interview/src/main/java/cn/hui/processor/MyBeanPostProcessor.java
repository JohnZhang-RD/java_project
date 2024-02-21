package cn.hui.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Name: MyBeanPostProcessor
 * Package: cn.hui.processor
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/02/21 - 16:04
 * @Version: v1.0
 */

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
