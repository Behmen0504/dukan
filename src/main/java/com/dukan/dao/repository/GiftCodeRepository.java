package com.dukan.dao.repository;

import com.dukan.dao.entity.GiftCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCodeRepository extends JpaRepository<GiftCodeEntity,Long> {
}
