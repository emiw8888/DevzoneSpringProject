package com.example.devzonespringproject.dao.repository;

import com.example.devzonespringproject.dao.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository
    extends JpaRepository<ContactEntity, Long> {
}
