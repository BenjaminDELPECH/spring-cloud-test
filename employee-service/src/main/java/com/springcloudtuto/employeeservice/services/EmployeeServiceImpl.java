package com.springcloudtuto.employeeservice.services;

import com.springcloudtuto.employeeservice.dtos.EmployeeDto;
import com.springcloudtuto.employeeservice.entities.Employee;
import com.springcloudtuto.employeeservice.entities.EmployeeRepository;
import com.springcloudtuto.employeeservice.exception.ResourceNotFoundException;
import com.springcloudtuto.employeeservice.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return employeeMapper.toDTO(
                employeeRepository.save(
                        employeeMapper.toEntity(
                                employeeDto
                        )
                )
        );
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "user",
                        "id",
                        id
                ));
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }
}
