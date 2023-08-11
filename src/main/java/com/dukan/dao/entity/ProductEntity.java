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
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @Enumerated(EnumType.STRING)
    Status status;
    Boolean stock = true;
    String stockCode;
    String Description;
    Double price;
    Integer sort;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    CategoryEntity category;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<ProductImageEntity> productImages;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    List<FavoriteEntity> favorites;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    List<OrderEntity> orders;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    List<CommentEntity> comments;
}
