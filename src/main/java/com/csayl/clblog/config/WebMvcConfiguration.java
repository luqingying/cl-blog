package com.csayl.clblog.config;

import com.csayl.clblog.interceptor.LogInterceptor;
import com.csayl.clblog.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: chen
 * @date: 2019/1/22
 **/

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final LogInterceptor logInterceptor;

    private final PermissionInterceptor permissionInterceptor;


    @Autowired
    public WebMvcConfiguration(LogInterceptor logInterceptor, PermissionInterceptor permissionInterceptor) {
        this.logInterceptor = logInterceptor;
        this.permissionInterceptor = permissionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        registry.addInterceptor(permissionInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");
    }
}
