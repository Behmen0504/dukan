package com.dukan.mapper;

import com.dukan.dao.entity.NewsEntity;
import com.dukan.model.NewsDTO;
import com.dukan.model.requests.NewsRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class NewsMapper {
    public static final NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    public abstract NewsDTO mapEntityToDto(NewsEntity newsEntity);
    public abstract NewsEntity mapDtoToEntity(NewsRequestDTO requestDTO);

    public List<NewsDTO> mapEntitiesToDtos(List<NewsEntity> newsEntities){
        return newsEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
