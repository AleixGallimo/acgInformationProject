package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.Article;
import com.qf.acgInformation.mapper.IArticleMapper;
import com.qf.acgInformation.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private IArticleMapper articleMapper;
    @Override
    public List<Article> getArticleByKeyWords(String keyWords) {
        return articleMapper.getArticleByKeyWords(keyWords);
    }
}
