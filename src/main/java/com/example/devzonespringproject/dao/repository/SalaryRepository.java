package com.example.devzonespringproject.dao.repository;

import com.example.devzonespringproject.dao.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository
    extends  JpaRepository<SalaryEntity, Long> {
}
