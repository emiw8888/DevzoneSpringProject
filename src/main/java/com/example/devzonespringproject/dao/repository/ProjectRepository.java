package com.example.devzonespringproject.dao.repository;

import com.example.devzonespringproject.dao.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepository
    extends JpaRepository<ProjectEntity, Long> {
    @Transactional
    @Modifying
    @Query("update ProjectEntity p set p.name = ?1, p.employee.id = ?2 where p.id = ?3")
    void update(String name, Long id, Long id1);

}
