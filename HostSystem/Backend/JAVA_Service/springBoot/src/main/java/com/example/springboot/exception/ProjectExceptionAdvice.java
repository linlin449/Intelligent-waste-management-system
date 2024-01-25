package com.example.springboot.exception;

import com.example.springboot.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j(topic = "异常处理器")
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有异常信息
    @ExceptionHandler
    public Result doException(Exception e) {
        e.printStackTrace();
        log.error("服务器内部异常");
        return new Result().fail("服务器异常!", null, ErrorCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public Result doException(UnauthorizedException e) {
        return new Result().fail("未授权", null, ErrorCode.UNAUTHORIZED_ERROR);
    }
}
