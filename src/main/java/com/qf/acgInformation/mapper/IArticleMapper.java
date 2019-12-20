package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IArticleMapper {

    //显示文章根据时间排序
    List<Article> getArticleByTime();

    //显示文章根据热度(阅读量)排序
    List<Article> getArticleOrderByRead();

    //显示对应标签的文章
    List<Article> getArticleByType(@Param("type") String type);

    //显示指定用户所写的文章
    List<Article> getArticleByUser(Integer userID);

    //显示用户订阅的文章
    List<Article> getArticleByUserSubscribe(Integer userID);

    //显示文章根据关键字查找
    List<Article> getArticleByKeyWords(@Param("keyWords") String keyWords);

    //显示指定用户所写的文章
    Article getArticleById(@Param("articleID") Integer articleID);

    //投稿文章
    Integer addArticle(@Param("article") Article article);

    //修改文章审核状态（默认1、通过2、不通过0）
    Integer updateArticleState(@Param("articleState") Article articleState);

    //删除/恢复文章(默认1，0为删除）
    Integer deleteArticle(@Param("articleDeleteID") Integer articleDeleteID ,@Param("articleIsDelete") Integer articleIsDelete);

    //文章增加收藏
    Integer updateLike(@Param("likeID") Integer likeID ,@Param("likeNum") Integer likeNum);

    //文章增加阅读量
    Integer updateRead(@Param("readID") Integer readID);
}
