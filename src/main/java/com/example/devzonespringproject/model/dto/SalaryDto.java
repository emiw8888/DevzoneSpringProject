package com.example.devzonespringproject.model.dto;

import com.example.devzonespringproject.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryDto {
    private Long id;
    private Integer amount;
    private Currency currency;
}