package com.dukan.model.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogRequestDTO {
    Long id;
    String title;
    String image;
    String description;
}
