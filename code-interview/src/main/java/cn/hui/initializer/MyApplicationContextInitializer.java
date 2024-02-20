package cn.hui.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Name: MyApplicationContextInitializer
 * Package: cn.hui.initializer
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/02/20 - 18:43
 * @Version: v1.0
 */

public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    // ioc容器对象创建完毕后执行
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

    }
}
