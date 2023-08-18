package com.dukan.dao.entity;

import com.dukan.myenums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    String address;
    @Enumerated(EnumType.STRING)
    Status status;


    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "product_id")
    ProductEntity product;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    UserEntity user;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    List<OrderDetailEntity> orderDetails;


}
