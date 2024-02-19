package cn.junhui.anno;

import cn.junhui.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


/**
 * Name: State
 * Package: cn.junhui.anno
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/25 - 18:13
 * @Version: v1.0
 */

@Documented // 元注解 --> 可抽取到文档中去
@Target({ElementType.FIELD}) // 元注解
@Retention(RetentionPolicy.RUNTIME) // 元注解
@Constraint(validatedBy = {StateValidation.class}) // 提供校验规则的类
public @interface State {
    // 提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或者草稿";
    // 指定分组
    Class<?>[] groups() default {};
    // 负载 获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
