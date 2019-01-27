package com.csayl.clblog.model.bo;

//import com.csayl.clblog.model.domain.User;

import com.csayl.clblog.model.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBo implements Serializable {
    private User user;
}
