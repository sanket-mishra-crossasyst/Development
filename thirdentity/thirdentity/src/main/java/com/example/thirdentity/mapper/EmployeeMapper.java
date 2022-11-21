package com.example.thirdentity.mapper;

import com.example.thirdentity.entity.EmployeeEntity;
import com.example.thirdentity.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeEntity modelToEntity(Employee employee);
    Employee   entityToModel(EmployeeEntity employeeEntity);
}
