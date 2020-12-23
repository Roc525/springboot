package com.mengxuegu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 绑定druid相关信息
 */
@Configuration
public  class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new DruidDataSource();
    }

    /***
     * 配置一个druid的监控
     * 1.配置一个druid的后台 管理servlet
     * 2.配置一个druid的Filter
     */

    @Bean
    public ServletRegistrationBean statVireServlet(){
        //注意：请求/druid/*
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParam = new HashMap<>();
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME,"root");
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD,"root");
        //如果不写，则默认所有IP都可以访问
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW,"");
        //禁用IP访问后台
        initParam.put(StatViewServlet.PARAM_NAME_DENY,"");
        servletRegistrationBean.setInitParameters(initParam);
        return  servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //设置拦截请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        Map<String, String> initPrams = new HashMap<>();
        initPrams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        bean.setInitParameters(initPrams);
        return  bean;
    }

}
