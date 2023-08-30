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

    @Mappings({
            @Mapping(source = "requestDto.categoryId", target = "category", qualifiedByName = "createCategoryEntity"),
    })
    public abstract ProductEntity mapProductRequestDtoToEntity(ProductRequestDTO requestDto);

    protected CategoryEntity createCategoryEntity(Long id) {
        if(id == null) return null;
        return CategoryEntity.builder().id(id).build();
    }

    public abstract List<ProductDTO> mapEntitiesToDtos(List<ProductEntity> productEntities);
}
