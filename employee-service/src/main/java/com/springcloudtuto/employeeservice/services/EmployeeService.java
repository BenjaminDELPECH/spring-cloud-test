package com.springcloudtuto.employeeservice.services;

import com.springcloudtuto.employeeservice.dtos.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
}
