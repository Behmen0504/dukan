package com.dukan.controller;

import com.dukan.model.ProductImageDTO;
import com.dukan.model.requests.ProductImageRequestDTO;
import com.dukan.service.ProductImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/productimages")
public class ProductImageController {
    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductImageDTO> getProductImages(){
        return productImageService.getProductImages();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductImageDTO getProductImage(@PathVariable Long id){
        return productImageService.getProductImage(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductImage(@RequestBody ProductImageRequestDTO requestDTO){
        productImageService.addProductImage(requestDTO);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProductImage(@PathVariable Long id,@RequestBody ProductImageRequestDTO requestDTO){
        productImageService.updateProductImage(id,requestDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductImage(@PathVariable Long id){
        productImageService.deleteProductImage(id);
    }

}
