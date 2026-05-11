package com.deccan.worklocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deccan.worklocation.entity.WorkLocationEntity;

@Repository
public interface workLocationRepo extends JpaRepository<WorkLocationEntity, Long> {
    
}
