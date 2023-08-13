package com.dukan.dao.repository;

import com.dukan.dao.entity.CommentEntity;
import com.dukan.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {


}
