package com.dukan.dao.repository;

import com.dukan.dao.entity.CategoryEntity;
import com.dukan.dao.entity.OrderEntity;
import com.dukan.myenums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> getOrderEntitiesByStatus(Status status);

    List<OrderEntity> getOrderEntitiesByProduct_Id(Long id);
    List<OrderEntity> getOrderEntitiesByUser_Id(Long id);

    OrderEntity findOrderEntityByIdAndStatus(Long id, Status status);
}
