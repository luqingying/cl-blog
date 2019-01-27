package com.csayl.clblog.mapper;

import com.csayl.clblog.model.domain.ArticleCategory;
import com.csayl.clblog.model.domain.ArticleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCategoryMapper {
    long countByExample(ArticleCategoryExample example);

    int deleteByExample(ArticleCategoryExample example);

    int deleteByPrimaryKey(Long articleCategoryId);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    List<ArticleCategory> selectByExample(ArticleCategoryExample example);

    ArticleCategory selectByPrimaryKey(Long articleCategoryId);

    int updateByExampleSelective(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByExample(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);
}