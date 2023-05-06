package com.test.universityapi.service.impl;

import com.test.universityapi.model.Department;
import com.test.universityapi.model.Salary;
import com.test.universityapi.repository.SalaryRepository;
import com.test.universityapi.service.DepartmentService;
import com.test.universityapi.service.SalaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;

    private final DepartmentService departmentService;

    @Override
    public Salary create(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public BigDecimal getAverageSalaryByDepartment(String departmentName) {
        Department department = departmentService.getDepartmentByName(departmentName);
        List<Salary> salariesByDepartment = salaryRepository.getSalariesByDepartment(department);
        BigDecimal sum = salariesByDepartment.stream()
                .map(Salary::getSalarySize)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(new BigDecimal(salariesByDepartment.size()), 2,
                RoundingMode.HALF_UP);
    }

}
