package com.test.universityapi.service.impl;

import com.test.universityapi.model.Degree;
import com.test.universityapi.model.Department;
import com.test.universityapi.model.Lector;
import com.test.universityapi.repository.DepartmentRepository;
import com.test.universityapi.service.DepartmentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.getDepartmentByName(departmentName);
    }

    @Override
    public String getHeadOfDepartmentName(String departmentName) {
        return departmentRepository.getHeadOfDepartmentByDepartmentName(departmentName).getName();
    }

    @Override
    public Map<Degree, Integer> getDepartmentStatistics(String departmentName) {
        List<Lector> lectorsByDepartmentName =
                departmentRepository.getLectorsByDepartmentName(departmentName);
        Map<Degree, Integer> statistic = new HashMap<>();
        for (Degree degree : Degree.values()) {
            statistic.put(degree, 0);
        }
        lectorsByDepartmentName
                .forEach(lector -> statistic.merge(lector.getDegree(), 1, Integer::sum));
        return statistic;
    }

    @Override
    public Integer getCountOfEmployeeByDepartment(String departmentName) {
        return departmentRepository.getDepartmentByName(departmentName).getLectors().size();
    }

}
