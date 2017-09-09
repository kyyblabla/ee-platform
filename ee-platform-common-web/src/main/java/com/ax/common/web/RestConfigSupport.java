package com.ax.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

/**
 * Rest 相关配置
 * 启动程序需要引入（@Import）该配置来加载相关组件
 * Created by kyy on 2017/9/7.
 */
@Configuration
public class RestConfigSupport extends WebMvcConfigurerAdapter {

    @Bean
    public Object restExceptionHandler() {
        return new RestExceptionHandler();
    }

    @Bean
    public Object defaultRestController() {
        return new DefaultRestController();
    }


}
