package com.example.manytomanysecond.mapper;


import com.example.manytomanysecond.entity.DepartmentEntity;
import com.example.manytomanysecond.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
DepartmentEntity modelToEntity (Department department);
Department entityToModel (DepartmentEntity departmentEntity);
}
