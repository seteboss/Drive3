package com.project1.Drive3.controller;


import com.project1.Drive3.model.News;
import com.project1.Drive3.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainNewsController {

    private NewsService newsService;

    public MainNewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/list")
    public Iterable<News> list(){
        return newsService.list();
    }


}
