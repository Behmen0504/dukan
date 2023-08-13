package com.dukan.model.requests;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDTO {
    String name;

    Status status = Status.ENABLE;
    Boolean stock = true;
    String stockCode;
    String description;
    Double price;
    Integer sort;
    Long categoryId;
}
