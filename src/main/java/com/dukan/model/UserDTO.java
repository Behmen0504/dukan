package com.dukan.model;

import com.dukan.dao.entity.CommentEntity;
import com.dukan.dao.entity.FavoriteEntity;
import com.dukan.dao.entity.OrderEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    List<FavoriteDTO> favorites;

    List<OrderDTO> orders;

    List<CommentDTO> comments;

}
