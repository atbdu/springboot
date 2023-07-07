package com.atbdu.myspringboot.config;

import com.atbdu.myspringboot.intercepter.LoginHanderIntercepter;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Component
public class MyConfig implements WebMvcConfigurer {
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/","/login");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //true 后缀匹配，/xx 和/xx.*是等效的
        configurer.setUseSuffixPatternMatch(true);
//        configurer.setPathMatcher(new PathMatchConfigurer())
    }
}
