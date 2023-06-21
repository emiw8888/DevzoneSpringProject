package com.example.devzonespringproject.controller;

import com.example.devzonespringproject.model.dto.ContactDto;
import com.example.devzonespringproject.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDto> getContacts() {
        return contactService.getContacts();
    }
}
