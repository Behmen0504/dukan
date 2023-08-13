package com.dukan.dao.repository;

import com.dukan.dao.entity.SlideImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideImageRepository extends JpaRepository<SlideImageEntity,Long> {


}
