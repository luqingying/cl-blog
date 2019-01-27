package com.csayl.clblog.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {
    private Long logId;

    private String visitorIp;

    private String visitUrl;

    private Date gmtCreate;

    public Log(String visitorIp, String visitUrl, Date gmtCreate) {
        this.visitorIp = visitorIp;
        this.visitUrl = visitUrl;
        this.gmtCreate = gmtCreate;
    }
}