package com.dukan.dao.repository;

import com.dukan.dao.entity.ProductEntity;
import com.dukan.myenums.Status;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @EntityGraph("Product.category")
    List<ProductEntity> getProductEntitiesByStatus(Status status);
    List<ProductEntity> getProductEntitiesByCategory_Id(Long id);
    ProductEntity findProductEntityByIdAndStatus(Long id,Status status);
}
