package com.test.universityapi.controller;

import com.test.universityapi.model.Degree;
import com.test.universityapi.model.Department;
import com.test.universityapi.model.Lector;
import com.test.universityapi.model.Salary;
import com.test.universityapi.service.DepartmentService;
import com.test.universityapi.service.LectorService;
import com.test.universityapi.service.SalaryService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
@Profile("test")
public class MockController {

    private final DepartmentService departmentService;

    private final LectorService lectorService;

    private final SalaryService salaryService;

    @ShellMethod(key = "init")
    public String init() {

        Lector lectorAlice = new Lector();
        lectorAlice.setName("Alice");
        lectorAlice.setDegree(Degree.ASSISTANT);

        Lector lectorBob = new Lector();
        lectorBob.setName("Bob");
        lectorBob.setDegree(Degree.PROFESSOR);

        Lector lectorJohn = new Lector();
        lectorJohn.setName("John");
        lectorJohn.setDegree(Degree.ASSISTANT);

        Lector lectorBoris = new Lector();
        lectorBoris.setName("Boris");
        lectorBoris.setDegree(Degree.ASSOCIATE_PROFESSOR);

        Lector lectorRon = new Lector();
        lectorRon.setName("Ron");
        lectorRon.setDegree(Degree.ASSOCIATE_PROFESSOR);

        Lector lectorRita = new Lector();
        lectorRita.setName("Rita");
        lectorRita.setDegree(Degree.ASSISTANT);

        Lector lectorMaria = new Lector();
        lectorMaria.setName("Maria");
        lectorMaria.setDegree(Degree.PROFESSOR);

        lectorService.create(lectorAlice);
        lectorService.create(lectorBob);
        lectorService.create(lectorJohn);
        lectorService.create(lectorBoris);
        lectorService.create(lectorRon);
        lectorService.create(lectorRita);
        lectorService.create(lectorMaria);

        Department departmentHistory = new Department();
        departmentHistory.setName("History");
        departmentHistory.setHead(lectorBob);
        departmentHistory.setLectors(List.of(lectorBob, lectorAlice, lectorRita));

        Department departmentMath = new Department();
        departmentMath.setName("Math");
        departmentMath.setHead(lectorBob);
        departmentMath.setLectors(List.of(lectorMaria, lectorJohn, lectorRon));

        Department departmentAstrology = new Department();
        departmentAstrology.setName("Astrology");
        departmentAstrology.setHead(lectorMaria);
        departmentAstrology.setLectors(List.of(lectorBoris, lectorJohn));

        departmentService.create(departmentHistory);
        departmentService.create(departmentMath);
        departmentService.create(departmentAstrology);

        Salary salaryBobHistory = new Salary();
        salaryBobHistory.setSalaryOwner(lectorBob);
        salaryBobHistory.setDepartment(departmentHistory);
        salaryBobHistory.setSalarySize(new BigDecimal(599));

        Salary salaryAliceHistory = new Salary();
        salaryAliceHistory.setSalaryOwner(lectorAlice);
        salaryAliceHistory.setDepartment(departmentHistory);
        salaryAliceHistory.setSalarySize(new BigDecimal(499));

        Salary salaryRitaHistory = new Salary();
        salaryRitaHistory.setSalaryOwner(lectorRita);
        salaryRitaHistory.setDepartment(departmentHistory);
        salaryRitaHistory.setSalarySize(new BigDecimal(449));

        Salary salaryMariaMath = new Salary();
        salaryMariaMath.setSalaryOwner(lectorMaria);
        salaryMariaMath.setDepartment(departmentMath);
        salaryMariaMath.setSalarySize(new BigDecimal(599));

        Salary salaryJohnMath = new Salary();
        salaryJohnMath.setSalaryOwner(lectorJohn);
        salaryJohnMath.setDepartment(departmentMath);
        salaryJohnMath.setSalarySize(new BigDecimal(649));

        Salary salaryRonMath = new Salary();
        salaryRonMath.setSalaryOwner(lectorRon);
        salaryRonMath.setDepartment(departmentMath);
        salaryRonMath.setSalarySize(new BigDecimal(399));

        Salary salaryBorisAstrology = new Salary();
        salaryBorisAstrology.setSalaryOwner(lectorBoris);
        salaryBorisAstrology.setDepartment(departmentAstrology);
        salaryBorisAstrology.setSalarySize(new BigDecimal(399));

        Salary salaryJohnAstrology = new Salary();
        salaryJohnAstrology.setSalaryOwner(lectorJohn);
        salaryJohnAstrology.setDepartment(departmentAstrology);
        salaryJohnAstrology.setSalarySize(new BigDecimal(499));

        salaryService.create(salaryBobHistory);
        salaryService.create(salaryAliceHistory);
        salaryService.create(salaryRitaHistory);
        salaryService.create(salaryMariaMath);
        salaryService.create(salaryJohnMath);
        salaryService.create(salaryRonMath);
        salaryService.create(salaryBorisAstrology);
        salaryService.create(salaryJohnAstrology);

        return "done!";
    }

}
