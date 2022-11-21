package com.example.thirdentity.controller;

import com.example.thirdentity.model.Department;
import com.example.thirdentity.model.DepartmentResponse;
import com.example.thirdentity.model.Employee;
import com.example.thirdentity.model.EmployeeResponse;
import com.example.thirdentity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse>  createEmployee(@RequestBody Employee employee){
     EmployeeResponse employeeResponse=employeeService.createEmployee(employee);
     return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
    @PostMapping(path = "/departments",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponse>  createDepartment(@RequestBody Department department){
        DepartmentResponse departmentResponse=employeeService.createDepartment(department);
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }
}
