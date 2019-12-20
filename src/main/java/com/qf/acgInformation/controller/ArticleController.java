package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.Article;
import com.qf.acgInformation.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/article")
public class ArticleController {
    @Resource
     private IArticleService articleService;

    @RequestMapping("/search")
    public void getArticleByKeyWords(){
        List<Article> list = articleService.getArticleByKeyWords("成功");
        log.debug(""+list.size());
    }
}
