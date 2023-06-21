package com.example.devzonespringproject.mapper;

import com.example.devzonespringproject.dao.entity.SalaryEntity;
import com.example.devzonespringproject.model.dto.SalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class SalaryMapper {
    public static SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    public abstract SalaryDto mapEntityToDto(SalaryEntity salaryEntity);

    public abstract List<SalaryDto> mapEntitiesToDtos(List<SalaryEntity> salaryEntities);
}
