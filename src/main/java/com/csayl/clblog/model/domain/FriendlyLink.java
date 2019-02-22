package com.csayl.clblog.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendlyLink implements Serializable {
    private Integer linkId;

    private String linkUrl;

    private String linkDescription;

    private Date gmtCreate;

    private Date gmtModified;
}