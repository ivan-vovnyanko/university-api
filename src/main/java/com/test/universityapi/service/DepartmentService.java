package com.test.universityapi.service;

import com.test.universityapi.model.Degree;
import com.test.universityapi.model.Department;
import java.util.Map;

public interface DepartmentService {

    Department create(Department department);

    Department getDepartmentByName(String departmentName);

    String getHeadOfDepartmentName(String departmentName);

    Map<Degree, Integer> getDepartmentStatistics(String departmentName);

    Integer getCountOfEmployeeByDepartment(String departmentName);

}
