package com.datetime.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.datetime.dto.EmployeeDto;
import com.datetime.entity.Employee;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee toEntity(EmployeeDto.EmployeeRequest dto);
    EmployeeDto.EmployeeResponse toDto(Employee entity);
}
