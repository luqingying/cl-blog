package com.csayl.clblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: chen
 * @date: 2019/1/21
 **/
@Component
@ConfigurationProperties
@PropertySource(value = "classpath:blog.properties", encoding = "UTF-8")
public class CommentConfiguration {
    public static int MaxCommentContent;

    public static int MinCommentContent;

    public static int MaxCommentNum;

    public static int MinCommentNum;

    @Value("${max-comment-num}")
    public void setMaxCommentNum(String maxCommentNum) {
        CommentConfiguration.MaxCommentNum = Integer.parseInt(maxCommentNum.trim());
    }

    @Value("${max-comment-content}")
    public void setMaxCommentContent(String maxCommentContent) {
        CommentConfiguration.MaxCommentContent = Integer.parseInt(maxCommentContent);
    }

    @Value("${min-comment-content}")
    public void setMinCommentContent(String minCommentContent) {
        CommentConfiguration.MinCommentContent = Integer.parseInt(minCommentContent);
    }

    @Value("${min-comment-num}")
    public void setMinCommentNum(String minCommentNum) {
        CommentConfiguration.MinCommentNum = Integer.parseInt(minCommentNum);
    }
}
