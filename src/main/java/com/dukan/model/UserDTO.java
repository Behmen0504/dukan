package com.dukan.model;


import com.dukan.myenums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long id;
    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    String gender;
    Status status;

    List<FavoriteDTO> favorites;

    List<OrderDTO> orders;
}
