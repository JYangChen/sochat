package com.codull.sochat.handler;

import com.codull.sochat.exception.GlobalException;
import com.codull.sochat.utils.R;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: sochat
 * @description: 全局Runtime异常处理器
 * @author: anthony1314
 * @create: 2020-02-25 14:37
 **/
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R exception(Exception e) {
        e.printStackTrace();
        return new R(500, "系统异常");
    }

    @ExceptionHandler(value = GlobalException.class)
    public R globalException(GlobalException e) {
        e.printStackTrace();
        return new R(500, e.getMsg());
    }
}
