package cn.com.spring.springbootdemo.hello;

import cn.com.spring.springbootdemo.exception.UserNotExitsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("hhh")
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello")
    public String hello(){
        //级别由低到高
        logger.trace("trace");
        logger.debug("debug");
        //默认info
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        if(1==1){
            throw new UserNotExitsException();
        }
        return "index";
    }

    @RequestMapping("/success")
    public String success(Map map){
        map.put("status","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "index";
    }

}
