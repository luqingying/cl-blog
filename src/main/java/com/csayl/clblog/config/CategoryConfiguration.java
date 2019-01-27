package com.csayl.clblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: chen
 * @date: 2019/1/21
 **/

@Component
@ConfigurationProperties
@PropertySource(value = "classpath:blog.properties", encoding = "UTF-8")
public class CategoryConfiguration {
    public static int MaxCategoryContent;

    public static int MinCategoryContent;

    @Value("${max-category-content}")
    public void setMaxCategoryContent(String maxCategoryContent) {
        CategoryConfiguration.MaxCategoryContent = Integer.parseInt(maxCategoryContent);
    }

    @Value("${min-category-content}")
    public void setMinCategoryContent(String minCategoryContent) {
        CategoryConfiguration.MinCategoryContent = Integer.parseInt(minCategoryContent);
    }
}
