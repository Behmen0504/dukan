package com.dukan.model;

import com.dukan.myenums.Status;
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
    Status status;
    ProductDTO product;

    List<OrderDetailDTO> orderDetails;
}
