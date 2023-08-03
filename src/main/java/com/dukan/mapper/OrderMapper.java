package com.dukan.mapper;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.UserEntity;
import com.dukan.model.OrderDTO;
import com.dukan.model.requests.OrderRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class OrderMapper {
    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public abstract OrderDTO mapEntityToDto(OrderEntity orderEntity);

    @Mappings({
            @Mapping(source = "requestDto.productId", target = "product", qualifiedByName = "createProductEntity"),
            @Mapping(source = "requestDto.userId", target = "user", qualifiedByName = "createUserEntity")

    })
    public abstract OrderEntity mapOrderRequestDtoToEntity(OrderRequestDTO requestDto);

    protected ProductEntity createProductEntity(Long id) {
        return ProductEntity.builder().id(id).build();
    }
    protected UserEntity createUserEntity(Long id) {
        return UserEntity.builder().id(id).build();
    }

    public List<OrderDTO> mapEntitiesToDtos(List<OrderEntity> orderEntities){
        return orderEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}
