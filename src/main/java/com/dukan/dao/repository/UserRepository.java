package com.dukan.dao.repository;

import com.dukan.dao.entity.UserEntity;
import com.dukan.myenums.Status;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @EntityGraph("fullUser")
    List<UserEntity> findAll();
    UserEntity findUserEntityByIdAndStatus(Long id, Status status);
}
