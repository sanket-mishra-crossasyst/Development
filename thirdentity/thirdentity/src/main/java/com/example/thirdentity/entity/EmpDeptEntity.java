package com.example.thirdentity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "employee_department")
public class EmpDeptEntity {
    @Id
    @SequenceGenerator(name = "seq_emp_dept_id", initialValue = 1, sequenceName = "seq_emp_dept_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp_dept_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="emp_id")
    private EmployeeEntity employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id")
    private DepartmentEntity department;


    private Date startDate;
    private Date endDate;

    public EmpDeptEntity() {
    }

    public EmpDeptEntity(EmployeeEntity employee, DepartmentEntity department, Date startDate, Date endDate) {
        this.employee = employee;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return  true;
        if(!(o instanceof EmpDeptEntity)) return false;
        EmpDeptEntity that=(EmpDeptEntity)  o;
        return Objects.equals(employee.getFirstName(),that.employee.getFirstName())&&
                Objects.equals(department.getName(),that.department.getName())&&
                Objects.equals(startDate ,that.startDate)&&
                Objects.equals(endDate, that.endDate);
    }
    @Override
    public int hashCode(){
        return Objects.hash(employee.getFirstName(),department.getName(),startDate,endDate);
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookPublisher)) return false;
        BookPublisher that = (BookPublisher) o;
        return Objects.equals(book.getName(), that.book.getName()) &&
                Objects.equals(publisher.getName(), that.publisher.getName()) &&
                Objects.equals(publishedDate, that.publishedDate);
    }*/
}
