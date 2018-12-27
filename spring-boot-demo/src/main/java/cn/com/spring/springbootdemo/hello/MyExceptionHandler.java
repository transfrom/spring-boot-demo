package cn.com.spring.springbootdemo.hello;

import cn.com.spring.springbootdemo.exception.UserNotExitsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    /*@ResponseBody
    @ExceptionHandler(UserNotExitsException.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user notexits");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExitsException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.server.error.status_code",500);
        map.put("code","user notexits");
        map.put("message",e.getMessage());


        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
