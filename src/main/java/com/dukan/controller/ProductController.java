package com.dukan.controller;


import com.dukan.model.ProductDTO;
import com.dukan.model.requests.ProductRequestDTO;
import com.dukan.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequestDTO requestDTO){
        productService.addProduct(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        productService.updateProduct(id,productDTO);
    }
}
