package org.example.patientsvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Data
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;

    @NotNull @Email
    @Column(unique=true)
    private String email;

    @NotNull
    private String address;

    @NotNull
    @Column(unique = true)
    private String phone;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @Column
    private LocalDateTime addedOn;

    @NotNull
    @Column
    private LocalDateTime updatedon;


}
