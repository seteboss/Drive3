package com.project1.Drive3.service;


import com.project1.Drive3.model.News;
import com.project1.Drive3.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Iterable<News> list(){
        return newsRepository.findAll();
    }

    public News save(News news){
        return newsRepository.save(news);
    }


    public void save(List<News> newss){
        newsRepository.saveAll(newss);
    }


}
