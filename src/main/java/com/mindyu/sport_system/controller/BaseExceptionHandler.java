package com.mindyu.sport_system.controller;

import com.mindyu.sport_system.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class BaseExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(HttpServletResponse httpServletResponse, Exception e) throws IOException, ServletException {
        e.printStackTrace();        
        System.out.println( "出错信息："+ e.getMessage());
        return new Result( 100, "执行出错");
    }
}
