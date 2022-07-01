package com.MFtravel.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//这是一个Mybatis配置类
@MapperScan("com.MFtravel.mapper")  //包扫描，扫描mapper包下的BaseMapper，这样才能注入
@Configuration
public class MybatisConfig {

    /**
     * 分页插件，必须添加后mybatis-plus分页服务才会生效
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
