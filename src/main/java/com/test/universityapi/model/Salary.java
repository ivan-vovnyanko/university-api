package com.test.universityapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Long id;

    private BigDecimal salarySize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_owner")
    private Lector salaryOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_department")
    private Department department;

}
