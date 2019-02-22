package com.csayl.clblog.model.bo;

import com.csayl.clblog.model.domain.FriendlyLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: chen
 * @date: 2019/1/18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendlyLinkBo implements Serializable {
    private FriendlyLink link;
}
