package com.springcloudtuto.departmentservice.controllers;

import com.springcloudtuto.departmentservice.dtos.DepartmentDTO;
import com.springcloudtuto.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departments")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departementService;

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDTO departmentDTO = departementService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(
                departmentDTO,
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartmentDTO = departementService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(
                savedDepartmentDTO,
                HttpStatus.CREATED
        );
    }
}
