package com.dukan.mapper;

import com.dukan.dao.entity.CategoryEntity;
import com.dukan.model.CategoryDTO;
import com.dukan.model.requests.CategoryRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class CategoryMapper {
    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract CategoryDTO mapEntityToDto(CategoryEntity categoryEntity);

    public abstract CategoryEntity mapDtoToEntity(CategoryDTO categoryDTO);

    public abstract CategoryEntity mapCategoryRequestDtoToEntity(CategoryRequestDTO requestDto);

    public abstract List<CategoryDTO> mapEntitiesToDtos(List<CategoryEntity> categoryEntities);

}