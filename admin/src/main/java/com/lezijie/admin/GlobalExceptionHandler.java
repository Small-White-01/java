package com.lezijie.admin;


import com.lezijie.admin.exception.MsgException;
import com.lezijie.admin.info.ResponseInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@RestControllerAdvice//全局处理异常,全局数据处理
public class GlobalExceptionHandler {


    @ExceptionHandler(MsgException.class)
    public ResponseInfo msgException(MsgException e){
        return ResponseInfo.error(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseInfo exception(Exception e){
        return ResponseInfo.error(e.getMessage());
    }


//    @ExceptionHandler(FreeMarkerViewResolver)

}
