package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.Article;

import java.util.List;

public interface IArticleService {


    List<Article> getArticleByKeyWords(String keyWords);
}
