package com.csayl.clblog.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleCategory  implements Serializable {
    private Long articleCategoryId;

    private Long pArticleId;

    private Long pCategoryId;

    private Date gmtCreate;

    private Date gmtModified;
}