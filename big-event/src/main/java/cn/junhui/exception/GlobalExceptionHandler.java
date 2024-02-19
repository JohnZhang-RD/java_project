package cn.junhui.exception;

import cn.junhui.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Name: GlobalExceptionHandler
 * Package: cn.junhui.exception
 * Description:
 *
 * @author Junhui Zhang
 * @Date: 2024/01/21 - 15:00
 * @Version: v1.0
 */

// 全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace(); // 异常信息输出到控制台
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }
}
