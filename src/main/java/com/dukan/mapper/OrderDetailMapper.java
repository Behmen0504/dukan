package com.dukan.mapper;

import com.dukan.dao.entity.OrderDetailEntity;
import com.dukan.model.OrderDetailDTO;
import com.dukan.model.requests.OrderDetailRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class OrderDetailMapper {
    public static final OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    public abstract OrderDetailDTO mapEntityToDto(OrderDetailEntity orderDetailEntity);
    public abstract OrderDetailEntity mapDtoToEntity(OrderDetailDTO orderDetailDTO);

    public abstract OrderDetailEntity mapOrderDetailRequestDtoToEntity(OrderDetailRequestDTO requestDto);

    public List<OrderDetailDTO> mapEntitiesToDtos(List<OrderDetailEntity> orderDetailEntities){
        return orderDetailEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
