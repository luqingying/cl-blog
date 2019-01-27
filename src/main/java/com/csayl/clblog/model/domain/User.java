package com.csayl.clblog.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userImageUrl;

    private Boolean isAdmin;

    private Date gmtCreate;

    private Date gmtModified;
}