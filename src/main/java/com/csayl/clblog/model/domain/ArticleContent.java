package com.csayl.clblog.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleContent  implements Serializable {
    private Long contentId;

    private Long pArticleId;

    private String content;

    private Date gmtCreate;

    private Date gmtModified;
}