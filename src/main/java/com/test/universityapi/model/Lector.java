package com.test.universityapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lectors")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lector_id")
    private Long id;

    @Column(name = "lector_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "lector_degree")
    private Degree degree;

}
