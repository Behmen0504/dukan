package com.dukan.model;

import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {
    Long id;
    String name;
    String icon;
    Boolean isShowingHomePage;
    Status status;
    Integer sort;
}
