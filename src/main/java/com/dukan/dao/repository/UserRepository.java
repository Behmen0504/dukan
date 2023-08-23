package com.dukan.dao.repository;

import com.dukan.dao.entity.UserEntity;
import com.dukan.myenums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findUserEntityByIdAndStatus(Long id, Status status);
}
