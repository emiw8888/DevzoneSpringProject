package com.example.devzonespringproject.mapper;

import com.example.devzonespringproject.dao.entity.EmployeeEntity;
import com.example.devzonespringproject.model.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class EmployeeMapper {
    public static EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "projects", ignore = true)
    public abstract EmployeeEntity mapDtoToEntity(EmployeeDto employeeDto);

    public abstract EmployeeDto mapEntityToDto(EmployeeEntity employeeEntity);

    public abstract List<EmployeeDto> mapEntitiesToDtos(List<EmployeeEntity> employeeEntities);

    public static EmployeeEntity editEmployeeEntity(EmployeeEntity employeeEntity, EmployeeDto employeeDto) {
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setSurname(employeeDto.getSurname());
        employeeEntity.getContact().setAddress(employeeDto.getContact().getAddress());
        employeeEntity.getContact().setEmail(employeeDto.getContact().getEmail());
        employeeEntity.getContact().setPhoneNumber(employeeDto.getContact().getPhoneNumber());
        employeeEntity.getSalary().setAmount(employeeDto.getSalary().getAmount());
        employeeEntity.getSalary().setCurrency(employeeDto.getSalary().getCurrency());
        return employeeEntity;
    }
}
