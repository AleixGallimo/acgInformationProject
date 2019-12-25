package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.Article;
import com.qf.acgInformation.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    //搜索
    @RequestMapping("/search")
    public List<Article> getArticleByKeyWords(String keyWords){
        List<Article> list = articleService.getArticleByKeyWords(keyWords);
        return list;
    }

    //通过文章ID获取文章
    @RequestMapping("/getArticleById")
    public Article getArticleById(Integer id){
        Article article = articleService.getArticleById(id);
        articleService.updateRead(id);
        return article;
    }

    //返回指定类型的文章
    @RequestMapping("/type")
    public List<Article> getArticleByType(String type){
        List<Article> list = articleService.getArticleByType(type);
        return list;
    }

    //index载入时自动加载最新的文章
    @RequestMapping("/load")
    public List<Article> getArticleByTime(){
        List<Article> list = articleService.getArticleByTime();
        return list;
    }

    @RequestMapping("/getAllArticle")
    public List<Article> getAllArticle( Integer offset, Integer pageSize){
        List<Article> list = articleService.getAllArticle(offset, pageSize);
        return list;
    }

    //返回热门(阅读量高)文章
    @RequestMapping("/read")
    public List<Article> getArticleOrderByRead(){
        List<Article> list = articleService.getArticleOrderByRead();
        return list;
    }

    //返回指定作者的文章
    @RequestMapping("/author")
    public List<Article> getArticleByUser(Integer userID){
        return articleService.getArticleByUser(userID);
    }

    //返回用户订阅列表的文章
    @RequestMapping("/subscribeUser")
    public void getArticleByUserSubscribe(){
        List<Article> list = articleService.getArticleByUserSubscribe(2);
        log.debug(list.get(0).toString());
        log.debug(list.get(1).toString());
    }

    //投稿前上传图片并回显
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

    //投稿
    @RequestMapping( value = "/add" ,method = RequestMethod.POST)
    public Integer addArticle(@RequestBody Article article,HttpServletRequest request){
        article.setAState(2);
        //获取提交日期
         LocalDate date = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         article.setADate(formatter.format(LocalDateTime.now() ));
        Integer uid =(Integer)request.getSession().getAttribute("uid");
        article.setAAuthor(uid);
         //存入文章对象进数据库
        Integer row = articleService.addArticle(article);
        return row;
    }

    //删除文章
    @RequestMapping("/delete")
    public String deleteArticle(Integer aId){
         articleService.deleteArticle(aId, 0);
         return "删除成功";
    }

    //审核通过文章（默认为1、2为通过）
    @RequestMapping("/state")
    public String updateArticleState(Integer aId , HttpServletResponse response) throws IOException {
        articleService.updateArticleState(new Article(aId,2));
        response.sendRedirect("/acgInformation/admin/article.html");
        return "审核通过";
    }

    //点赞
    @RequestMapping("/addLike")
    public void  addLike(Integer aId){
        articleService.updateLike(aId,1);
    }
}
