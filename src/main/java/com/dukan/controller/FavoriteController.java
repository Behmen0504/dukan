package com.dukan.controller;


import com.dukan.model.FavoriteDTO;
import com.dukan.model.requests.FavoriteRequestDTO;
import com.dukan.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FavoriteDTO> getFavorites(){
        return favoriteService.getFavorites();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FavoriteDTO getFvorites(@PathVariable Long id){
        return favoriteService.getFavorite(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavorite(@RequestBody FavoriteRequestDTO requestDTO){
        favoriteService.addFavorite(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFavorite(@PathVariable Long id,@RequestBody FavoriteDTO favoriteDTO){
        favoriteService.updateFavorite(id,favoriteDTO);
    }
}
