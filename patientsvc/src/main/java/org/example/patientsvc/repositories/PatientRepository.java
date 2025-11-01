package org.example.patientsvc.repositories;

import org.example.patientsvc.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, java.util.UUID> {
    boolean existByEmailOrPhone(String email, String phone);
}
