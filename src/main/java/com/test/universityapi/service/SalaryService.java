package com.test.universityapi.service;

import com.test.universityapi.model.Salary;
import java.math.BigDecimal;

public interface SalaryService {

    Salary create(Salary salary);

    BigDecimal getAverageSalaryByDepartment(String departmentName);

}
