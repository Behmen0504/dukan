package com.dukan.mapper;

import com.dukan.dao.entity.*;
import com.dukan.model.BlogDTO;
import com.dukan.model.requests.BlogRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class BlogMapper {
    public static final BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    public abstract BlogDTO mapEntityToDto(BlogEntity blogEntity);

    public abstract BlogEntity mapBlogRequestDtoToEntity(BlogRequestDTO requestDto);

    public abstract List<BlogDTO> mapEntitiesToDtos(List<BlogEntity> blogEntities);
}
