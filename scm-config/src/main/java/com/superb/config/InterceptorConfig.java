package com.superb.config;

import com.superb.config.interceptor.ParamsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ParamsInterceptor()).addPathPatterns("/*");

        //.excludePathPatterns("/api2/xxx/**"); //拦截全部 /*/*/**

        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
