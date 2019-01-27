package com.csayl.clblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
@MapperScan("com.csayl.clblog.mapper")
public class ClBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClBlogApplication.class, args);
    }

}

