package com.example.thirdentity.model;

import com.example.thirdentity.entity.EmpDeptEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private String name;
    private Set<EmpDeptEntity> emplployeeDepartments;
}
