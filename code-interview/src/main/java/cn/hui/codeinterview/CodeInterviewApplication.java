package cn.hui.codeinterview;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Zhang Junhui
 */

@SpringBootApplication
public class CodeInterviewApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CodeInterviewApplication.class, args);
        // 该属性有其他作用，不是打印出去
        /*String application = context.getEnvironment().getProperty("applicationName");
        System.out.println(application);*/

        /*System.out.println(context.getClass());
        CodeInterviewApplication bean = context.getBean(CodeInterviewApplication.class);
        System.out.println(bean);*/

        // 获取BeanDefinition对象  --》 不知道为什么下面这段代码始终获取不到bean name
        /*ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition user = beanFactory.getBeanDefinition("user");
        BeanDefinition say = beanFactory.getBeanDefinition("say");
        System.out.println(user.getClass());
        System.out.println(say.getClass());*/
        // 和上面情况相同
//        System.out.println(context.getBean("teacher"));


    }

}
