package com.csayl.clblog.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Category  implements Serializable {
    private Long categoryId;

    private String categoryContent;

    private Date gmtCreate;

    private Date gmtModified;
}