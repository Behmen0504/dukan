package com.dukan.dao.entity;

import com.dukan.myenums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String phoneNumber;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    @JoinColumn(name = "product_id")
    List<ProductEntity> products;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    UserEntity user;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    List<OrderDetailEntity> orderDetails;


}
