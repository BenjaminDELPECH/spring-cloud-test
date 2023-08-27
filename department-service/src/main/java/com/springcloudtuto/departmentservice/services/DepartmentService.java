package com.springcloudtuto.departmentservice.services;

import com.springcloudtuto.departmentservice.dtos.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentByCode(String code);
}
