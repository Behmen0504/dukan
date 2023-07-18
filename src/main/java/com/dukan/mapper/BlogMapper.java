package com.dukan.mapper;

import com.dukan.dao.entity.BlogEntity;
import com.dukan.model.dto.BlogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class BlogMapper {
    public static final BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    public abstract List<BlogDTO> entityToDtoList(List<BlogEntity> blogEntities);

    public abstract BlogDTO entityToDto(BlogEntity blogEntity);

    public abstract BlogEntity dtoToEntity(BlogDTO blogDTO);
}