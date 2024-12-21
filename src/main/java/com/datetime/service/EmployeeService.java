package com.datetime.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datetime.dto.EmployeeDto;
import com.datetime.entity.Employee;
import com.datetime.mapper.EmployeeMapper;
import com.datetime.repository.EmployeeRespository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRespository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto.EmployeeResponse saveEmployee(EmployeeDto.EmployeeRequest entity) {
        Employee employee = employeeMapper.toEntity(entity);
        employee.setCreatedDate(LocalDateTime.now());
        employee.setUpdatedDate(LocalDateTime.now());
        employee.setId(UUID.randomUUID().toString());
        Employee empObj= employeeRepository.save(employee);
        return employeeMapper.toDto(empObj);
    }

    public List<EmployeeDto.EmployeeResponse> getAllEmployee() {
        List<Employee> empList=employeeRepository.findAll();
        return empList.stream().map(r->employeeMapper.toDto(r)).toList();
    }
}
