package com.springcloudtuto.departmentservice.mapper;

import com.springcloudtuto.departmentservice.dtos.DepartmentDTO;
import com.springcloudtuto.departmentservice.entities.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends GenericMapper<DepartmentDTO, Department> {
}
