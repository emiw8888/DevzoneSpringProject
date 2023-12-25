package com.example.devzonespringproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {
    private Long id;

    private String email;

    private String phoneNumber;

    private String address;
}
