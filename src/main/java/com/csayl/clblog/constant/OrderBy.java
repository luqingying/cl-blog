package com.csayl.clblog.constant;

/**
 * @author: chen
 * @date: 2019/1/19
 **/
public enum OrderBy {

    CREATE_TIME_DESC("gmt_create desc"), CREATE_TIME_ASC("gmt_create asc");
    private String field;

    OrderBy(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
