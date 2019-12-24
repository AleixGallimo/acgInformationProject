package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.Article;
import com.qf.acgInformation.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/article")
public class ArticleController {
    @Resource
     private IArticleService articleService;

    @RequestMapping("/search")
    public List<Article> getArticleByKeyWords(String keyWords){
        List<Article> list = articleService.getArticleByKeyWords(keyWords);
        return list;
    }

    @RequestMapping("/getArticleById")
    public Article getArticleById(Integer id){
        Article article = articleService.getArticleById(id);
        return article;
    }

    @RequestMapping("/type")
    public List<Article> getArticleByType(String type){
        List<Article> list = articleService.getArticleByType(type);
        return list;
    }
    @RequestMapping("/typeSearch")
    public boolean getArticleByTypeSearch(){
        return true;
    }

    @RequestMapping("/load")
    public List<Article> getArticleByTime(){
        List<Article> list = articleService.getArticleByTime();
        return list;
    }
    @RequestMapping("/read")
    public List<Article> getArticleOrderByRead(){
        List<Article> list = articleService.getArticleOrderByRead();
        return list;
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
    @RequestMapping(value = "/image",method = RequestMethod.POST)
    private String getArticlePic(MultipartFile upload, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("images");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        String filename = upload.getOriginalFilename();
        log.debug(filename);
        filename= UUID.randomUUID().toString()+"_"+filename;
        log.debug(filename);
        upload.transferTo(new File(file,filename));
        String imgSrc="images/"+filename;
        //返回图片路径
        return imgSrc;
    }

    @RequestMapping( value = "/add" ,method = RequestMethod.POST)
    public Integer addArticle(@RequestBody Article article){
        article.setAState(2);
        log.debug("aaaa " + article);
        //获取提交日期
         LocalDate date = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         article.setADate(formatter.format(LocalDateTime.now() ));
         article.setAAuthor(1);
         //存入文章对象进数据库
        Integer row = articleService.addArticle(article);
        return row;
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
}
