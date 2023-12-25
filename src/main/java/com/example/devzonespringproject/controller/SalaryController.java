package com.example.devzonespringproject.controller;

import com.example.devzonespringproject.model.dto.SalaryDto;
import com.example.devzonespringproject.service.SalaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/salaries")
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public List<SalaryDto> getSalaries() {
        return salaryService.getSalaries();
    }
}
