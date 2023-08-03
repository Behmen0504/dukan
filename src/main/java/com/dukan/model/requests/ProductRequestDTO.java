package com.dukan.model.requests;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDTO {
    Long id;
    String name;

    Status status = Status.ENABLE;
    Boolean stock = true;
    String stockCode;
    String Description;
    Double price;
    Integer sort;
    Long categoryId;
    List<Long> productImageIds;
    List<Long> favoriteIds;
}
