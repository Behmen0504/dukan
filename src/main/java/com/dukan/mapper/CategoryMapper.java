package com.dukan.mapper;

import com.dukan.dao.entity.CategoryEntity;
import com.dukan.model.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CategoryMapper {
    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract List<CategoryDTO> entityToDtoList(List<CategoryEntity> categoryEntities);

    public abstract CategoryDTO entityToDto(CategoryEntity categoryEntity);

    public abstract CategoryEntity dtoToEntity(CategoryDTO categoryDTO);
}