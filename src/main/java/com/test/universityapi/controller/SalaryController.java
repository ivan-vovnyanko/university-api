package com.test.universityapi.controller;

import com.test.universityapi.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    @ShellMethod(key = "Show the average salary for the department")
    public String getAverageSalaryByDepartment(@ShellOption String departmentName) {
        return salaryService.getAverageSalaryByDepartment(departmentName).toString();
    }

}
