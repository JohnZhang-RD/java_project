package cn.hui.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * Name: Student
 * Package: cn.hui.aware
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/02/21 - 15:39
 * @Version: v1.0
 */

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
