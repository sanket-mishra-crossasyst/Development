package com.example.manytomanysecond.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employee_two")
public class EmployeeEntity {
    @Id
    @SequenceGenerator(name = "seq_emp_id_2", initialValue = 1, sequenceName = "seq_emp_id_2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp_id_2")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EmployeeDepartmentEntity> employeeDepartmentEntitySet;
}
