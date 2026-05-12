package com.psychology.api.common.exception;

import com.psychology.api.common.ReturnMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常处理
 * @author: wuming
 * @create: 2023-04-15 16:26:32
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ReturnMsg handle(Exception e) {
        e.printStackTrace();
        return ReturnMsg.error(e.getMessage());
    }

}
