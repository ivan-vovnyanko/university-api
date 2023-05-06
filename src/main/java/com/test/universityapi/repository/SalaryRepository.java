package com.test.universityapi.repository;

import com.test.universityapi.model.Department;
import com.test.universityapi.model.Salary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<Salary> getSalariesByDepartment(Department department);

}
