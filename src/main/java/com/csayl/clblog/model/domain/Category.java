package com.csayl.clblog.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private Long categoryId;

    private String categoryContent;

    private Date gmtCreate;

    private Date gmtModified;
}