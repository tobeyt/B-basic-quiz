package com.tw.qd.repository;

import com.tw.qd.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EducationRepository extends JpaRepository<EducationEntity, Long> {
    List<EducationEntity> findAllByUserEntityId(long userId);
}
