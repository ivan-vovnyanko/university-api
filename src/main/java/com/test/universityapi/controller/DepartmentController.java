package com.test.universityapi.controller;

import com.test.universityapi.model.Degree;
import com.test.universityapi.service.DepartmentService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @ShellMethod(key = "Who is head of department")
    public String getHeadOfDepartment(@ShellOption String departmentName) {
        String headOfDepartmentName = departmentService.getHeadOfDepartmentName(departmentName);
        return "Head of " + departmentName + " department is " + headOfDepartmentName;
    }

    @ShellMethod(key = "Show")
    public String getDepartmentStatistics(@ShellOption({"departmentName"}) String departmentName) {
        String string = departmentName.split(" statistics")[0];
        Map<Degree, Integer> departmentStatistics
                = departmentService.getDepartmentStatistics(string);
        StringBuilder answer = new StringBuilder();
        departmentStatistics.forEach((key, value) ->
                answer.append(key.getDegreeName())
                        .append(" - ")
                        .append(value)
                        .append("\n"));
        return answer.toString().trim();
    }

    @ShellMethod(key = "Show count of employee for")
    public String getCountOfEmployeeByDepartmentName(@ShellOption String departmentName) {
        return departmentService.getCountOfEmployeeByDepartment(departmentName).toString();
    }

}