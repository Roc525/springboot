package com.mengxuegu.springboot.config;

import com.mengxuegu.springboot.component.myLocalResolver;
import com.mengxuegu.springboot.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mySpringMvcConfigler {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        //指定拦截的请求
                        .addPathPatterns("/**")
                        //指定不需要拦截的请求
                        .excludePathPatterns("/","/index.html","/login")
                        //srpingboot2+需要将静态资料的路径拦截
                        .excludePathPatterns("/css/*","/img/*","/js/*");
            }
        };
    }

    //语言区域解析器
    @Bean
    public LocaleResolver localeResolver(){
     return new myLocalResolver();
    }
}
