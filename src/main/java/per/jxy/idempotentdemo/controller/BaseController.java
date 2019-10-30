package per.jxy.idempotentdemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import per.jxy.idempotentdemo.commons.ServerResponse;
import per.jxy.idempotentdemo.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request,Exception exception){
        Map<String,String> resData = new HashMap<>();

        if (exception instanceof ServiceException){
            resData.put("msg",((ServiceException) exception).getExceptionMsg());
            resData.put("status","fail");
        }else{
            resData.put("msg","位置错误");
            resData.put("status","fail");
        }
        return ServerResponse.create(resData.get("msg"),resData.get("status"));
    }

}
