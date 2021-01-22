package com.esalagea.jpasample.data;

import com.esalagea.jpasample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.dept = :department")
    List<Employee> findByDept(@Param("department") String dept);

}