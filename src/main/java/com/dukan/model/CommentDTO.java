package com.dukan.model;

import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDTO {
    Long id;

    String message;

    int productRate;

    boolean anonymousComment;

    ProductDTO product;

    UserDTO user;

    CommentDTO comment;
}
