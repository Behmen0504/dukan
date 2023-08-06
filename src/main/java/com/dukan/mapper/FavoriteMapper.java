package com.dukan.mapper;

import com.dukan.dao.entity.FavoriteEntity;
import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.UserEntity;
import com.dukan.model.FavoriteDTO;
import com.dukan.model.requests.FavoriteRequestDTO;
import com.dukan.model.requests.ProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class FavoriteMapper {
    public static final FavoriteMapper INSTANCE = Mappers.getMapper(FavoriteMapper.class);

    public abstract FavoriteDTO mapEntityToDto(FavoriteEntity favoriteEntity);
    public abstract FavoriteEntity mapDtoToEntity(FavoriteDTO favoriteDTO);

    @Mappings({
            @Mapping(source = "requestDto.productId", target = "product", qualifiedByName = "createProductEntity"),
            @Mapping(source = "requestDto.userId", target = "user", qualifiedByName = "createUserEntity")

    })
    public abstract FavoriteEntity mapFavoriteRequestDtoToEntity(FavoriteRequestDTO requestDto);

    protected ProductEntity createProductEntity(Long id) {
        return ProductEntity.builder().id(id).build();
    }
    protected UserEntity createUserEntity(Long id) {
        return UserEntity.builder().id(id).build();
    }
    public List<FavoriteDTO> mapEntitiesToDtos(List<FavoriteEntity> favoriteEntities){
        return favoriteEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}