package com.dukan.model.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentRequestDTO {
    String message;

    Integer productRate;

    boolean anonymousComment;

    Long productId;

    Long userId;

    Long commentId;
}
