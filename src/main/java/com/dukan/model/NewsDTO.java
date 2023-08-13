package com.dukan.model;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsDTO {
    Long id;
    String title;
    String image;
    String description;
    Status status;
}
