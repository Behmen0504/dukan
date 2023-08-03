package com.dukan.controller;

import com.dukan.model.BlogDTO;
import com.dukan.model.requests.BlogRequestDTO;
import com.dukan.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BlogDTO> getBlogs(){
        return blogService.getBlogs();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogDTO getBlog(@PathVariable Long id){
        return blogService.getBlog(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBlog(@RequestBody BlogRequestDTO requestDTO){
        blogService.addBlog(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBlog(@PathVariable Long id,@RequestBody BlogRequestDTO requestDTO){
        blogService.updateBlog(id,requestDTO);
    }
}
