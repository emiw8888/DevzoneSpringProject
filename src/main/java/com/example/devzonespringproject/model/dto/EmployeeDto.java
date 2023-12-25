package com.example.devzonespringproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;

    private String name;

    private String surname;

    private SalaryDto salary;

    private ContactDto contact;

    private List<ProjectDto> projects;
}
