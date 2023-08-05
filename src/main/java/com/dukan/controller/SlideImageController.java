package com.dukan.controller;

import com.dukan.model.SlideImageDTO;
import com.dukan.model.requests.SlideImageRequestDTO;
import com.dukan.service.SlideImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/slideimages")
public class SlideImageController {
    private final SlideImageService slideImageService;

    public SlideImageController(SlideImageService slideImageService) {
        this.slideImageService = slideImageService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SlideImageDTO> getSlideImages(){
        return slideImageService.getSlideImages();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SlideImageDTO getSlideImage(@PathVariable Long id){
        return slideImageService.getSlideImage(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addSlideImage(@RequestBody SlideImageRequestDTO requestDTO){
        slideImageService.addSlideImage(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSlideImage(@PathVariable Long id,@RequestBody SlideImageRequestDTO requestDTO){
        slideImageService.updateSlideImage(id,requestDTO);
    }
}
