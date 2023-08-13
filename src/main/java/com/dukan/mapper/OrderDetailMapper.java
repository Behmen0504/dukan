package com.dukan.mapper;

import com.dukan.dao.entity.OrderDetailEntity;
import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.entity.UserEntity;
import com.dukan.model.OrderDetailDTO;
import com.dukan.model.requests.OrderDetailRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class OrderDetailMapper {
    public static final OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    public abstract OrderDetailDTO mapEntityToDto(OrderDetailEntity orderDetailEntity);
    public abstract OrderDetailEntity mapDtoToEntity(OrderDetailDTO orderDetailDTO);

    @Mappings({
            @Mapping(source = "requestDto.orderId", target = "orderr", qualifiedByName = "createOrderEntity"),
            @Mapping(source = "requestDto.userId", target = "user", qualifiedByName = "createUserEntity")

    })
    public abstract OrderDetailEntity mapOrderDetailRequestDtoToEntity(OrderDetailRequestDTO requestDto);

    protected OrderEntity createOrderEntity(Long id) {
        if(id == null) return null;
        return OrderEntity.builder().id(id).build();
    }
    protected UserEntity createUserEntity(Long id) {
        if(id == null) return null;
        return UserEntity.builder().id(id).build();
    }

    public List<OrderDetailDTO> mapEntitiesToDtos(List<OrderDetailEntity> orderDetailEntities){
        return orderDetailEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
