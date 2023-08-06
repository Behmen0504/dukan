package com.dukan.service;

import com.dukan.dao.entity.FavoriteEntity;
import com.dukan.dao.repository.FavoriteRepository;
import com.dukan.mapper.FavoriteMapper;
import com.dukan.model.FavoriteDTO;
import com.dukan.model.requests.FavoriteRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public List<FavoriteDTO> getFavorites() {
        log.info("ActionLog.getFavorites start");
        List<FavoriteDTO> favoriteDTOS = FavoriteMapper.INSTANCE.mapEntitiesToDtos(favoriteRepository.findAll());
        log.info("ActionLog.getFavorites end");
        return favoriteDTOS;
    }

    public FavoriteDTO getFavorite(Long id) {
        log.info("ActionLog.getFavorite start");
        FavoriteDTO favoriteDTO = FavoriteMapper.INSTANCE.mapEntityToDto(favoriteRepository.findById(id).get());
        log.info("ActionLog.getFavorite end");
        return favoriteDTO;
    }
    public void addFavorite(FavoriteRequestDTO requestDTO) {
        log.info("ActionLog.addFavorite start");
        FavoriteEntity favoriteEntity = FavoriteMapper.INSTANCE.mapFavoriteRequestDtoToEntity(requestDTO);
        favoriteRepository.save(favoriteEntity);
        log.info("ActionLog.addFavorite end");
    }

    public void updateFavorite(Long id, FavoriteDTO favoriteDTO) {
        log.info("ActionLog.updateFavorite start");
        FavoriteEntity favoriteEntity = favoriteRepository.findById(id).get();
//        newsRepository.save(favoriteEntity);
        log.info("ActionLog.updateFavorite end");
    }
}
