package cn.hui.definition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Name: MyConfig
 * Package: cn.hui.definition
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/02/20 - 22:13
 * @Version: v1.0
 */

@Configuration
public class MyConfig {

    @Bean
    public String say() {
        return "I love beautiful girls";
    }
}
