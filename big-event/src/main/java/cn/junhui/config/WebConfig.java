package cn.junhui.config;

import cn.junhui.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Name: WebConfig
 * Package: cn.junhui.config
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 19:14
 * @Version: v1.0
 */

@Configuration // 配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry是一个注册器
        // 注册loginInterceptor
        // 登录接口和注册接口不拦截
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login", "/user/register");
    }
}
