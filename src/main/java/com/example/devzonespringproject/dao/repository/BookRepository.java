package com.example.devzonespringproject.dao.repository;

import com.example.devzonespringproject.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository
    extends PagingAndSortingRepository<BookEntity, Long>, JpaRepository<BookEntity, Long> {
}
