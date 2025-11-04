package org.example.patientsvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "doctor_availability")
@Data
public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctors doctor;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isAvailable;
    private LocalDateTime addedOn;
    private LocalDateTime updatedOn;
}

