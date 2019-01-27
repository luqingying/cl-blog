package com.csayl.clblog.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FriendlyLink  implements Serializable {
    private Integer linkId;

    private String linkUrl;

    private String linkDescription;

    private Date gmtCreate;

    private Date gmtModified;
}