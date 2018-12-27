package cn.com.spring.springbootdemo.config;

import cn.com.spring.springbootdemo.componet.MyLocaleResolver;
import cn.com.spring.springbootdemo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
