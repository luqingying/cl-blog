package com.csayl.clblog.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private Long commentId;

    private String commentContent;

    private Long pCommentId;

    private Long rootCommentId;

    private Long pUserId;

    private Long pArticleId;

    private Date gmtCreate;

    private Date gmtModified;
}