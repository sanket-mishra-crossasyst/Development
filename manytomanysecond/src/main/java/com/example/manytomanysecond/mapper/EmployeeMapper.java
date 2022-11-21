package com.example.manytomanysecond.mapper;

import com.example.manytomanysecond.entity.EmployeeEntity;
import com.example.manytomanysecond.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToModel(EmployeeEntity employeeEntity);

    EmployeeEntity modelToEntity(Employee employee);
}
