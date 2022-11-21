package com.example.manytomanysecond.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "department_two")
public class DepartmentEntity {
    @Id
    @SequenceGenerator(name = "seq_dept_id_2", initialValue = 1, sequenceName = "seq_dept_id_2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dept_id_2")
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "department")
    private Set<EmployeeDepartmentEntity> departmentEntities;
}
