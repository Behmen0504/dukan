package com.dukan.mapper;

import com.dukan.dao.entity.QuestionEntity;
import com.dukan.model.QuestionDTO;
import com.dukan.model.requests.QuestionRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class QuestionMapper {
    public static final QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    public abstract QuestionDTO mapEntityToDto(QuestionEntity questionEntity);

    public abstract QuestionEntity mapQuestionRequestDtoToEntity(QuestionRequestDTO requestDto);

    public abstract List<QuestionDTO> mapEntitiesToDtos(List<QuestionEntity> questionEntities);
}
