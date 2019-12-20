package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.Article;
import com.qf.acgInformation.mapper.IArticleMapper;
import com.qf.acgInformation.service.IArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private IArticleMapper articleMapper;

    @Override
    public List<Article> getArticleByTime() {
        return articleMapper.getArticleByTime();
    }

    @Override
    public List<Article> getArticleOrderByRead() {
        return articleMapper.getArticleOrderByRead();
    }

    @Override
    public List<Article> getArticleByType(String type) {
        return articleMapper.getArticleByType(type);
    }

    @Override
    public List<Article> getArticleByUser(@Param("userID") Integer userID) {
        return articleMapper.getArticleByUser(userID);
    }

    @Override
    public List<Article> getArticleByUserSubscribe(@Param("subscribeUserID") Integer userID) {
        return articleMapper.getArticleByUserSubscribe(userID);
    }

    @Override
    public List<Article> getArticleByKeyWords(String keyWords) {
        return articleMapper.getArticleByKeyWords(keyWords);
    }

    @Override
    public Article getArticleById(Integer articleID) {
        return articleMapper.getArticleById(articleID);
    }

    @Override
    public Integer addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public Integer updateArticleState(Article articleState) {
        return articleMapper.updateArticleState(articleState);
    }

    @Override
    public Integer deleteArticle(Integer articleDeleteID ,Integer articleIsDelete) {
        return articleMapper.deleteArticle(articleDeleteID ,articleIsDelete);
    }

    @Override
    public Integer updateLike(Integer likeID , Integer likeNum) {
        return articleMapper.updateLike(likeID,likeNum);
    }

    @Override
    public Integer updateRead(Integer readID) {
        return articleMapper.updateRead(readID);
    }
}
