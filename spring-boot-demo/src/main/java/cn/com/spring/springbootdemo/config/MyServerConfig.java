package cn.com.spring.springbootdemo.config;

import cn.com.spring.springbootdemo.server.MyFilter;
import cn.com.spring.springbootdemo.server.MyListener;
import cn.com.spring.springbootdemo.server.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean myServlet = new ServletRegistrationBean(new MyServlet(),"/mySerlvet");
        return myServlet;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean myFilter = new FilterRegistrationBean();
        myFilter.setFilter(new MyFilter());
        myFilter.setUrlPatterns(Arrays.asList("/hello","/mySerlvet"));
        return myFilter;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> myListener = new ServletListenerRegistrationBean(new MyListener());
        return myListener;
    }

    //定制嵌入式web容器配置
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }



}
