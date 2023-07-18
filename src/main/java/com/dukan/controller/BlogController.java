package com.dukan.controller;

import com.dukan.model.dto.BlogDTO;
import com.dukan.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/blogs")
public class BlogController {
    public final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<BlogDTO> getBlogs() {
        return blogService.getBlogs();
    }

    @GetMapping("/{id}")
    public BlogDTO getBlog(@PathVariable Long id)  {
        return blogService.getBlog(id);
    }
    @PostMapping
    public String addBlog(@RequestBody BlogDTO blogDTO){
        blogService.addBlog(blogDTO);
        return "Blog successfully added!";
    }

    @PutMapping("/{id}")
    public String updateBlog(@PathVariable Long id,@RequestBody BlogDTO blogDTO){
        blogService.updateBlog(id,blogDTO);
        return "Blog was updated";
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id){
        blogService.deleteBlog(id);
        return "Blog was deleted";
    }

}
