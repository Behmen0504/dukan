package com.dukan.mapper;

import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.ProductImageEntity;
import com.dukan.model.ProductDTO;
import com.dukan.model.ProductImageDTO;
import com.dukan.model.requests.ProductImageRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class ProductImageMapper {
    public static final ProductImageMapper INSTANCE = Mappers.getMapper(ProductImageMapper.class);

    public abstract ProductImageDTO mapEntityToDto(ProductImageEntity productImageEntity);

    @Mappings({
            @Mapping(source = "requestDto.productId", target = "product", qualifiedByName = "createProductEntity")
    })
    public abstract ProductImageEntity mapProductImageRequestDtoToEntity(ProductImageRequestDTO requestDto);


    protected ProductEntity createProductEntity(Long id) {
        if (id == null) return null;
        return ProductEntity.builder().id(id).build();
    }

        public abstract List<ProductImageDTO> mapEntitiesToDtos(List<ProductImageEntity> productImageEntities);
//    public List<ProductImageDTO> mapEntitiesToDtos(List<ProductImageEntity> productImageEntities) {
//        return productImageEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
//    }
}
