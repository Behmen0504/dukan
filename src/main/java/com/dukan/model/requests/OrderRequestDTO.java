package com.dukan.model.requests;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDTO {
    String phoneNumber;

    String address;

    Status status = Status.ENABLE;

    Long productId;

    Long userId;
}
