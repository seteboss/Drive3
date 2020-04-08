package com.project1.Drive3.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Drive3.model.News;
import com.project1.Drive3.service.NewsService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;



@RestController
public class NewsEdit {

    private NewsService newsService;

    public NewsEdit(NewsService newsService) {
        this.newsService = newsService;
    }


    @RequestMapping("/edit")
    public void EditNews() throws IOException, URISyntaxException {

        String url = "https://jsonplaceholder.typicode.com/todos/";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();

        List<Object> list = springParser.parseList(resp);

        for (Object o : list) {
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) o;
                System.out.println("Items found: " + map.size());

                int i = 0;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                    i++;
                }

            }
        }


    /*
    @RequestMapping("/edit")
    public void EditNews() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        URL url = this.getClass().getClassLoader().getResource("test.json");
        File jsonFile = new File(url.getFile());

        try {
            List<News> news = objectMapper.readValue(jsonFile, new TypeReference<List<News>>(){});
            newsService.save(news);
            System.out.println("Сохранено");

        } catch (IOException e) {
            System.out.println("Не сохранено " + e.getMessage());
        }

    }*/

    }
}

