package com.test.universityapi.repository;

import com.test.universityapi.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("SELECT l FROM Lector l WHERE l.name LIKE CONCAT('%', :template, '%')")
    List<Lector> getLectorsByNameTemplate(String template);

}
