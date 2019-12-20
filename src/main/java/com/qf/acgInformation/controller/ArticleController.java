package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.Article;
import com.qf.acgInformation.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        log.debug(list.get(0).toString());
    }

    @RequestMapping("/select")
    public void getArticleById(){
        Article article = articleService.getArticleById(2);
        log.debug(article.toString());
    }

    @RequestMapping("/type")
    public void getArticleByType(){
        List<Article> list = articleService.getArticleByType("游戏");
        log.debug(list.get(0).toString());
    }

    @RequestMapping("/time")
    public void getArticleByTime(){
        List<Article> list = articleService.getArticleByTime();
        log.debug(list.get(0).toString());
        log.debug(list.get(1).toString());
    }
    @RequestMapping("/read")
    public void getArticleOrderByRead(){
        List<Article> list = articleService.getArticleOrderByRead();
        log.debug(list.get(0).toString());
        log.debug(list.get(1).toString());
    }
    @RequestMapping("/user")
    public void getArticleByUser(){
        List<Article> list = articleService.getArticleByUser(1);
        log.debug(list.get(0).toString());
        log.debug(list.get(1).toString());
    }
    @RequestMapping("/subscribeUser")
    public void getArticleByUserSubscribe(){
        List<Article> list = articleService.getArticleByUserSubscribe(2);
        log.debug(list.get(0).toString());
        log.debug(list.get(1).toString());
    }
    @RequestMapping("/add")
    public void addArticle(){

//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        Article article = new Article("明星","王宝强、贾乃亮、陈羽凡桃园三结义",
//                "这是假新闻","https://ww1.sinaimg.cn/bmiddle/8a7b160cgy1g9v7kotkzvj20nf0akgm8.jpg"
//                ,2,date.format(formatter));
//        log.debug(articleService.addArticle(article).toString());
    }
    @RequestMapping("/delete")
    public void deleteArticle(){
        Integer isDelete = articleService.deleteArticle(2, 0);
        log.debug(isDelete.toString());
    }
    @RequestMapping("/state")
    public void updateArticleState(){
        Article article = new Article(1,0);
        Integer updateState = articleService.updateArticleState(article);
        log.debug(updateState.toString());
    }
    @RequestMapping("/addLike")
    public void updateLike(){
        Integer updateLike = articleService.updateLike(2,1);
        log.debug(updateLike.toString());
    }
    @RequestMapping("/addRead")
    public void updateRead(){
        Integer updateRead = articleService.updateRead(2);
        log.debug(updateRead.toString());
    }

}
