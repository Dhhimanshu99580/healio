package org.example.patientsvc.repositories;

import org.example.patientsvc.entities.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Long> {

    Optional<DoctorAvailability> findByDoctorIdAndDate(Long id, LocalDate localDate);
}
