package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IArticleMapper {

    //显示文章根据时间排序
    List<Article> getArticleByTime();

    //显示文章根据热度(阅读量)排序
    List<Article> getArticleByRead();

    //显示对应标签的文章
    List<Article> getArticleByType(String type);

    //显示指定用户所写的文章
    List<Article> getArticleByUser(Integer userID);

    //显示用户订阅的文章
    List<Article> getArticleByUserSubscibe(Integer userID);

    //显示文章根据关键字查找
    List<Article> getArticleByKeyWords(@Param("keyWords") String keyWords);

}
