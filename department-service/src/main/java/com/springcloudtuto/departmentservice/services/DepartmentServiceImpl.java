package com.springcloudtuto.departmentservice.services;

import com.springcloudtuto.departmentservice.dtos.DepartmentDTO;
import com.springcloudtuto.departmentservice.entities.DepartmentRepository;
import com.springcloudtuto.departmentservice.exception.ResourceNotFoundException;
import com.springcloudtuto.departmentservice.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;


    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        return departmentMapper.toDTO(
                departmentRepository.save(
                        departmentMapper.toEntity(
                                departmentDTO
                        )
                )
        );
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        return departmentMapper.toDTO(
                departmentRepository.findByDepartmentCode(code).orElseThrow(() -> new ResourceNotFoundException(
                        "department",
                        "departmentcode",
                        code
                ))
        );
    }
}
