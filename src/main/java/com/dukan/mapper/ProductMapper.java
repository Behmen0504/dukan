package com.dukan.mapper;

import com.dukan.dao.entity.*;
import com.dukan.model.ProductDTO;
import com.dukan.model.requests.ProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract ProductDTO mapEntityToDto(ProductEntity productEntity);
    public abstract ProductEntity mapDtoToEntity(ProductDTO productDTO);

    @Mappings({
            @Mapping(source = "requestDto.productImageIds", target = "productImages", qualifiedByName = "createProductImageEntity"),
            @Mapping(source = "requestDto.favoriteIds", target = "favorites", qualifiedByName = "createFavoriteEntity"),
            @Mapping(source = "requestDto.categoryId", target = "category", qualifiedByName = "createCategoryEntity"),
    })
    public abstract ProductEntity mapProductRequestDtoToEntity(ProductRequestDTO requestDto);

    protected List<ProductImageEntity> createProductImageEntity(List<Long> ids) {
        return ids.stream().map(id -> ProductImageEntity.builder().id(id).build()).collect(Collectors.toList());
    }
    protected List<FavoriteEntity> createFavoriteEntity(List<Long> ids) {
        return ids.stream().map(id -> FavoriteEntity.builder().id(id).build()).collect(Collectors.toList());
    }
    protected CategoryEntity createCategoryEntity(Long id) {
        return CategoryEntity.builder().id(id).build();
    }

    public List<ProductDTO> mapEntitiesToDtos(List<ProductEntity> productEntities){
        return productEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
