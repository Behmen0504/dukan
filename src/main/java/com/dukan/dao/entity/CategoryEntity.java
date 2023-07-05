package com.dukan.dao.entity;

import com.dukan.myenums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String icon;
    Boolean isShowingHomePage;
    @Enumerated(EnumType.STRING)
    Status status;
    Integer sort;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    List<ProductEntity> products;
}
