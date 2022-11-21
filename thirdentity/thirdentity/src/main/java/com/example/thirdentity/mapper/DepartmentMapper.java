package com.example.thirdentity.mapper;

import com.example.thirdentity.entity.DepartmentEntity;
import com.example.thirdentity.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentEntity modelToEntity(Department department);
    Department entityTOModel(DepartmentEntity departmentEntity);
}
