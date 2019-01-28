package com.csayl.clblog.model.bo;

import com.csayl.clblog.model.domain.Article;
import com.csayl.clblog.model.domain.ArticleContent;
import com.csayl.clblog.model.domain.Category;
import com.csayl.clblog.model.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBo implements Serializable {

    //文章作者
    private UserBo creator;

    private Article article;

    //文章内容
    private ArticleContent content;

    //文章所属类别
    private List<CategoryBo> categories;
}
