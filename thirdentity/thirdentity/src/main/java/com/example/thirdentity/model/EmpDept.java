package com.example.thirdentity.model;

import com.example.thirdentity.entity.DepartmentEntity;
import com.example.thirdentity.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpDept {
    private EmployeeEntity employee;
    private DepartmentEntity department;
    private Date startDate;
    private Date endDate;
}
