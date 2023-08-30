package com.dukan.model;

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

//    UserDTO user;

    CommentDTO comment;

}
