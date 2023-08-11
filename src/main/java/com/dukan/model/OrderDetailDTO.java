package com.dukan.model;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDTO {
    Long id;

    int countProduct;

    double priceForOne;

    OrderDTO orderr;

    UserDTO user;
}
