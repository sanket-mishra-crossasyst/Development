package com.example.thirdentity.service;

import com.example.thirdentity.entity.DepartmentEntity;
import com.example.thirdentity.entity.EmployeeEntity;
import com.example.thirdentity.mapper.DepartmentMapper;
import com.example.thirdentity.mapper.EmployeeMapper;
import com.example.thirdentity.model.Department;
import com.example.thirdentity.model.DepartmentResponse;
import com.example.thirdentity.model.Employee;
import com.example.thirdentity.model.EmployeeResponse;
import com.example.thirdentity.repository.DepartmentRepository;
import com.example.thirdentity.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public EmployeeResponse createEmployee(Employee employee){
        EmployeeEntity employeeEntity;
        employeeEntity=employeeMapper.modelToEntity(employee);
        employeeRepository.save(employeeEntity);
        log.info("Employee named {} {} created Successfully", employee.getFirstName(),employee.getLastName());
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        return employeeResponse;
    }


    public DepartmentResponse createDepartment(Department department) {
        DepartmentEntity departmentEntity;
        departmentEntity=departmentMapper.modelToEntity(department);
        departmentRepository.save(departmentEntity);
        log.info("Department named {} created Successfully",department.getName());
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setId(departmentEntity.getId());
        return departmentResponse;
    }

}