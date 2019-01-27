package com.csayl.clblog.model.bo;

import com.csayl.clblog.model.domain.FriendlyLink;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: chen
 * @date: 2019/1/18
 **/
@Data
public class FriendlyLinkBo implements Serializable {
    private FriendlyLink link;
}
