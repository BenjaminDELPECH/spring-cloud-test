package com.springcloudtuto.employeeservice.controllers;

import com.springcloudtuto.employeeservice.dtos.EmployeeDto;
import com.springcloudtuto.employeeservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping({"{id}"})
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDtoSaved = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(
                employeeDtoSaved,
                HttpStatus.CREATED
        );
    }
}
