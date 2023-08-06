package com.dukan.model.requests;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {
    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;
    String gender;
}
