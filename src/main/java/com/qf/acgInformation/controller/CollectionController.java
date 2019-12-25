package com.qf.acgInformation.controller;

import com.qf.acgInformation.service.ICollectionService;
import com.qf.acgInformation.service.impl.CollectionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * CHAN
 * 2019/12/24 14:17
 */
@Slf4j
@RestController
@RequestMapping(value = "/collection")
public class CollectionController {
    @Resource
    private ICollectionService collectionService;

    @RequestMapping(value = "/check")
    private Integer checkUid(Integer articleId, String type){
        log.debug(" " + articleId);
        Integer i = collectionService.getUserIdByArticleId(articleId, type);
        log.debug("" + i);
        return i;
    }

    @RequestMapping(value = "/add")
    private Integer addLikeOrMoney(Integer userId, Integer articleId, String type){
        return collectionService.addLikeOrMoney(userId, articleId, type);
    }
}
