package com.example.devzonespringproject.service;

import com.example.devzonespringproject.dao.entity.SalaryEntity;
import com.example.devzonespringproject.dao.repository.SalaryRepository;
import com.example.devzonespringproject.mapper.SalaryMapper;
import com.example.devzonespringproject.model.dto.SalaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SalaryService {
    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<SalaryDto> getSalaries(){
        log.info("ActionLog.getSalaries.start");
        List<SalaryEntity> salaryEntities = salaryRepository.findAll();
        log.info("ActionLog.getSalaries.end");
        return SalaryMapper.INSTANCE.mapEntitiesToDtos(salaryEntities);
    }
}
