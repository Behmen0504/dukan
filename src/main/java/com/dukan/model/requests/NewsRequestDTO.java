package com.dukan.model.requests;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsRequestDTO {
    String title;
    String image;
    String description;
    Status status = Status.ENABLE;
}
