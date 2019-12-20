package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.Article;


import java.util.List;

public interface IArticleService {


    //显示文章根据时间排序
    List<Article> getArticleByTime();

    //显示文章根据热度(阅读量)排序
    List<Article> getArticleOrderByRead();

    //显示对应标签的文章
    List<Article> getArticleByType(String type);

    //显示指定用户所写的文章
    List<Article> getArticleByUser(Integer userID);

    //显示用户订阅的文章
    List<Article> getArticleByUserSubscribe(Integer userID);

    //显示文章根据关键字查找
    List<Article> getArticleByKeyWords(String keyWords);

    //显示指定用户所写的文章
    Article getArticleById(Integer articleID);

    //投稿文章
    Integer addArticle(Article article);

    //修改文章审核状态（默认1、通过2、不通过0）
    Integer updateArticleState(Article articleState);

    //删除/恢复文章(默认1，0为删除）
    Integer deleteArticle(Integer articleDeleteID ,Integer articleIsDelete);

    //文章增加收藏
    Integer updateLike(Integer likeID , Integer likeNum);

    //文章增加阅读量
     Integer updateRead(Integer readID);
}
