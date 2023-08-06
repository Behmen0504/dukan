package com.dukan.controller;

import com.dukan.model.CategoryDTO;
import com.dukan.model.requests.CategoryRequestDTO;
import com.dukan.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody CategoryRequestDTO requestDTO){
        categoryService.addCategory(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@PathVariable Long id,@RequestBody CategoryRequestDTO requestDTO){
        categoryService.updateCategory(id,requestDTO);
    }
}
