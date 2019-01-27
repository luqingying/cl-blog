package com.csayl.clblog.model.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Image {
    private Long imageId;

    private String imageUrl;

    private Date gmtCreate;

    private Date gmtModified;
}