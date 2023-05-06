package com.test.universityapi.repository;

import com.test.universityapi.model.Department;
import com.test.universityapi.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d.head FROM Department d WHERE d.name = :name")
    Lector getHeadOfDepartmentByDepartmentName(String name);

    @Query("SELECT d.lectors FROM Department d WHERE d.name = :name")
    List<Lector> getLectorsByDepartmentName(String name);

    @Query("SELECT d FROM Department d JOIN FETCH d.lectors JOIN FETCH d.head WHERE d.name = :name")
    Department getDepartmentByName(String name);

}
