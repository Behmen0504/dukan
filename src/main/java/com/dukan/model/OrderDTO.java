package com.dukan.model;

import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDTO {
    Long id;

    String phoneNumber;
    String address;

    ProductEntity product;

    UserEntity user;

    List<OrderDetailDTO> orderDetails;
}
