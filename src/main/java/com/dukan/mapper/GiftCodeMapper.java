package com.dukan.mapper;

import com.dukan.dao.entity.GiftCodeEntity;
import com.dukan.model.GiftCodeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class GiftCodeMapper {
    public static final GiftCodeMapper INSTANCE = Mappers.getMapper(GiftCodeMapper.class);

    public abstract GiftCodeDTO mapEntityToDto(GiftCodeEntity giftCodeEntity);
    public abstract GiftCodeEntity mapDtoToEntity(GiftCodeDTO giftCodeDTO);

    public List<GiftCodeDTO> mapEntitiesToDtos(List<GiftCodeEntity> giftCodeEntities){
        return giftCodeEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
