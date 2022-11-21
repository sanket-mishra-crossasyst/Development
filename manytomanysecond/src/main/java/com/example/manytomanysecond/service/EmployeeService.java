package com.example.manytomanysecond.service;

import com.example.manytomanysecond.entity.EmployeeEntity;
import com.example.manytomanysecond.mapper.EmployeeMapper;
import com.example.manytomanysecond.model.Employee;
import com.example.manytomanysecond.model.EmployeeResponse;
import com.example.manytomanysecond.repository.DepartmentRepository;
import com.example.manytomanysecond.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;

    }

    public EmployeeResponse createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = null;
        employeeEntity = employeeMapper.modelToEntity(employee);
        employeeRepository.save(employeeEntity);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        log.info("create with id {} ", employeeResponse);
        return employeeResponse;
    }

  /*  public Employee getEmployeeById(Long id) {

        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        Employee employee = new Employee();
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employee = employeeMapper.entityToModel(employeeEntity);
            log.info("employee found with id {} ", id);
        } else {
            log.info("employee id {} not found", id);
        }
        return employee;
    }

    public void deleteEmployeeById(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isPresent()) {
            employeeRepository.deleteById(id);
            log.info("deleted successfully with id {}", id);
        } else {
            log.info("id {} not found", id);
        }

    }

    public void updateEmployee(Long empId, Long id) {
        Set<DepartmentEntity> departmentEntitySet = null;
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        departmentEntitySet = employeeEntity.getDepartments();
        departmentEntitySet.add(departmentEntity);
        employeeEntity.setDepartments(departmentEntitySet);
        employeeRepository.save(employeeEntity);
    }*/
}




