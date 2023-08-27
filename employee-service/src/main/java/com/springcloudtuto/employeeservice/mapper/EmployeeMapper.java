package com.springcloudtuto.employeeservice.mapper;

import com.springcloudtuto.employeeservice.dtos.EmployeeDto;
import com.springcloudtuto.employeeservice.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<EmployeeDto, Employee>{
}
