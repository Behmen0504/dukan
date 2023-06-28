package com.dukan.dao.entity;

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
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String status;
    Boolean stock = true;
    String stockCode;
    String Description;
    Double price;
    Integer sort;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updateAt;
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Categories category;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    List<ProductImages> productImages;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Favorites> favorites;


}
