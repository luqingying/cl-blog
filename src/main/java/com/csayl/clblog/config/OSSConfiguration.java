package com.csayl.clblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: chen
 * @date: 2019/1/22
 **/

@Component
@ConfigurationProperties
@PropertySource(value = "classpath:oss.properties", encoding = "UTF-8")
public class OSSConfiguration {
    public static String AccessKey;

    public static String SecretKey;

    public static String Bucket;

    public static String Domain;

    @Value("${qiniu.accessKey}")
    public void setAccessKey(String accessKey) {
        AccessKey = accessKey;
    }

    @Value("${qiniu.secretKey}")
    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    @Value("${qiniu.bucket}")
    public void setBucket(String bucket) {
        Bucket = bucket;
    }

    @Value("${qiniu.domain}")
    public void setPath(String path) {
        Domain = path;
    }
}
