package com.dukan.model.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDTO {
    Long id;

    String phoneNumber;

    String address;

    Long productId;

    Long userId;
}