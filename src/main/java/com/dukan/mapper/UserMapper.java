package com.dukan.mapper;

import com.dukan.dao.entity.UserEntity;
import com.dukan.model.UserDTO;
import com.dukan.model.requests.UserRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDTO mapEntityToDto(UserEntity userEntity);

    public abstract UserEntity mapUserRequestDtoToEntity(UserRequestDTO requestDto);

    public abstract List<UserDTO> mapEntitiesToDtos(List<UserEntity> userEntities);
}
