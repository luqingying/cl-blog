package com.csayl.clblog.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private Long articleId;

    private Long articleUserId;

    private String articleName;

    private String articleCoverUrl;

    private String articleDescription;

    private Integer articleReading;

    private Boolean articleIsDeleted;

    private Boolean articleIsTop;

    private Date gmtCreate;

    private Date gmtModified;

    public Article(Integer articleReading) {
        this.articleReading = articleReading;
    }
}