package com.dukan.model;

import com.dukan.dao.entity.*;
import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    Long id;
    String name;

    Status status;
    Boolean stock = true;
    String stockCode;
    String Description;
    Double price;
    Integer sort;
    CategoryEntity category;
    List<ProductImageDTO> productImages;
    List<CommentDTO> comments;

}
