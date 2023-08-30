package com.dukan.dao.repository;

import com.dukan.dao.entity.CategoryEntity;
import com.dukan.myenums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    List<CategoryEntity> getCategoryEntitiesByStatus(Status status);
    CategoryEntity findCategoryEntityByIdAndStatus(Long id, Status status);
}
