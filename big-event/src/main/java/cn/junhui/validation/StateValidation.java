package cn.junhui.validation;

import cn.junhui.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Name: StateValidation
 * Package: cn.junhui.validation
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/25 - 20:19
 * @Version: v1.0
 */

public class StateValidation implements ConstraintValidator<State,String> { // <给那个注解提供校验，校验的类型>
    /**
     *
     * @param s 将来要校验的数据
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 提供校验规则
        if (s == null) {
            return false;
        }
        if (s.equals("已发布") || s.equals("草稿")) {
            return true;
        }
        return false;
    }
}
