package com.MFtravel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HtmlConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login/login");
        registry.addViewController("/regist").setViewName("regist/regist");
        registry.addViewController("/dashboard").setViewName("dashboard/travel");
        registry.addViewController("/route_list").setViewName("route/route_list");
        registry.addViewController("/route_detail").setViewName("route/route_detail");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
