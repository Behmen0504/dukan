package com.dukan.controller;

import com.dukan.model.NewsDTO;
import com.dukan.model.requests.NewsRequestDTO;
import com.dukan.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDTO> getNews(){
        return newsService.getNews();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsDTO getNewsById(@PathVariable Long id){
        return newsService.getNewsById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addNews(@RequestBody NewsRequestDTO requestDTO){
        newsService.addNews(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateNews(@PathVariable Long id,@RequestBody NewsRequestDTO requestDTO){
        newsService.updateNews(id,requestDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id){
        newsService.deleteNews(id);
    }

}
