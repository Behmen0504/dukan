package com.dukan.mapper;

import com.dukan.dao.entity.SlideImageEntity;
import com.dukan.model.SlideImageDTO;
import com.dukan.model.requests.SlideImageRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class SlideImageMapper {
    public static final SlideImageMapper INSTANCE = Mappers.getMapper(SlideImageMapper.class);

    public abstract SlideImageDTO mapEntityToDto(SlideImageEntity slideImageEntity);

    public abstract SlideImageEntity mapSlideImageRequestDtoToEntity(SlideImageRequestDTO requestDto);

    public List<SlideImageDTO> mapEntitiesToDtos(List<SlideImageEntity> slideImageEntities){
        return slideImageEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
