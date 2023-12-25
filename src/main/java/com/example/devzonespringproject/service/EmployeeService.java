package com.example.devzonespringproject.service;

import com.example.devzonespringproject.dao.entity.EmployeeEntity;
import com.example.devzonespringproject.dao.repository.EmployeeRepository;
import com.example.devzonespringproject.mapper.EmployeeMapper;
import com.example.devzonespringproject.model.dto.EmployeeDto;
import com.example.devzonespringproject.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getEmployees() {
        log.info("ActionLog.getEmployees.start");
        List<EmployeeEntity> employees = employeeRepository.findAll();
        log.info("ActionLog.getEmployees.end");
        return EmployeeMapper.INSTANCE.mapEntitiesToDtos(employees);
    }

    public EmployeeDto getEmployee(Long id) {
        log.info("ActionLog.getEmployee.start with id: {}", id);
        EmployeeEntity employee = getEmployeeIfExist(id);
        log.info("ActionLog.getEmployee.end with id: {}", id);
        return EmployeeMapper.INSTANCE.mapEntityToDto(employee);
    }

    public void addEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(
            EmployeeMapper.INSTANCE.mapDtoToEntity(employeeDto))
        ;
    }

    public void editEmployee(EmployeeDto employeeDto, Long id) {
        log.info("ActionLog.editEmployee.start with id: {}", id);
        EmployeeEntity employeeEntity = getEmployeeIfExist(id);
        employeeRepository.save(
            EmployeeMapper.editEmployeeEntity(employeeEntity, employeeDto)
        );
        log.info("ActionLog.editEmployee.end with id: {}", id);
    }

    public void deleteEmployee(Long id) {
        log.info("ActionLog.deleteEmployee.start with id: {}", id);
        employeeRepository.deleteById(id);
        log.info("ActionLog.deleteEmployee.end with id: {}", id);
    }

    private EmployeeEntity getEmployeeIfExist(Long id) {
        return employeeRepository.findById(id).orElseThrow(
            () -> {
                log.error("ActionLog.employeeNotFound.withId: {}", id);
                throw new NotFoundException("EMPLOYEE_NOT_FOUND");
            }
        );
    }
}
