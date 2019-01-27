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
public class UserConfiguration {
    public static int MaxUsernameLength;

    public static int MinUsernameLength;

    public static int MaxPasswordLength;

    public static int MinPasswordLength;

    public static String PasswordSalt;

    @Value("${max-username-length}")
    public void setMaxUsernameLength(String maxUsernameLength) {
        UserConfiguration.MaxUsernameLength = Integer.parseInt(maxUsernameLength);
    }

    @Value("${min-username-length}")
    public void setMinUsernameLength(String minUsernameLength) {
        UserConfiguration.MinUsernameLength = Integer.parseInt(minUsernameLength);
    }

    @Value("${max-password-length}")
    public void setMaxPasswordLength(String maxPasswordLength) {
        UserConfiguration.MaxPasswordLength = Integer.parseInt(maxPasswordLength);
    }

    @Value("${min-password-length}")
    public void setMinPasswordLength(String minPasswordLength) {
        UserConfiguration.MinPasswordLength = Integer.parseInt(minPasswordLength);
    }

    @Value("${password-salt}")
    public void setPasswordSalt(String passwordSalt) {
        UserConfiguration.PasswordSalt = passwordSalt;
    }
}
