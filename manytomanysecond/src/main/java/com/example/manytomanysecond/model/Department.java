package com.example.manytomanysecond.model;

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
    private Set<Employee> employeeDepartmentEntitySet;
}
