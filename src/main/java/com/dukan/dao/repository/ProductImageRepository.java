package com.dukan.dao.repository;

import com.dukan.dao.entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Long> {
//    @EntityGraph("Product.productImages")
    List<ProductImageEntity> getProductImageEntitiesByProduct_Id(Long id);
}
