package com.example.devzonespringproject.service;

import com.example.devzonespringproject.dao.entity.ContactEntity;
import com.example.devzonespringproject.dao.repository.ContactRepository;
import com.example.devzonespringproject.mapper.ContactMapper;
import com.example.devzonespringproject.model.dto.ContactDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactDto> getContacts(){
        log.info("ActionLog.getContacts.start");
        List<ContactEntity> contactEntities = contactRepository.findAll();
        log.info("ActionLog.getContacts.end");
        return ContactMapper.INSTANCE.mapEntitiesToDtos(contactEntities);
    }

}
