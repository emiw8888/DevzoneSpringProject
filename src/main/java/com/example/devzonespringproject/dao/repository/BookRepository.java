package com.example.devzonespringproject.dao.repository;

import com.example.devzonespringproject.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository
    extends JpaRepository<BookEntity, Long> , JpaSpecificationExecutor<BookEntity> {
}
