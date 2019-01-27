package com.csayl.clblog.mapper;

import com.csayl.clblog.model.domain.ArticleContent;
import com.csayl.clblog.model.domain.ArticleContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleContentMapper {
    long countByExample(ArticleContentExample example);

    int deleteByExample(ArticleContentExample example);

    int deleteByPrimaryKey(Long contentId);

    int insert(ArticleContent record);

    int insertSelective(ArticleContent record);

    List<ArticleContent> selectByExample(ArticleContentExample example);

    ArticleContent selectByPrimaryKey(Long contentId);

    int updateByExampleSelective(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    int updateByExample(@Param("record") ArticleContent record, @Param("example") ArticleContentExample example);

    int updateByPrimaryKeySelective(ArticleContent record);

    int updateByPrimaryKey(ArticleContent record);
}