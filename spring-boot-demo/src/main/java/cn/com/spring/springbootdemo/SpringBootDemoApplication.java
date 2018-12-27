package cn.com.spring.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import javax.swing.*;
import java.util.Locale;

/**
 * @ImportResourc 引入外部配置文件
 */
@SpringBootApplication
//@ImportResource(locations =	{"classpath:beans.xml"})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		//new SpringApplicationBuilder(SpringBootDemoApplication.class)
	}

	/*@Bean
	public ViewResolver myViewResolver(){
		return new MyViewResolver();
	}

	private static class MyViewResolver implements ViewResolver{

		@Nullable
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}*/
}
