package com.dukan.model.requests;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequestDTO {
    String name;
    String icon;
    Boolean isShowingHomePage;
    Status status = Status.ENABLE;
    Integer sort;
}
