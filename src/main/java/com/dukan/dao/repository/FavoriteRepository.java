package com.dukan.dao.repository;

import com.dukan.dao.entity.FavoriteEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity,Long> {
    @EntityGraph("fullFavorite")
    List<FavoriteEntity> findAll();

    void deleteByUser_Id(Long id);
}
