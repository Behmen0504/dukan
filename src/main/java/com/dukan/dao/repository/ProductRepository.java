package com.dukan.dao.repository;

import com.dukan.dao.entity.ProductEntity;
import com.dukan.myenums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> getProductEntitiesByStatus(Status status);
}
