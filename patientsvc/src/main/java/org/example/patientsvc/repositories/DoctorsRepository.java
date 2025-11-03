package org.example.patientsvc.repositories;

import org.example.patientsvc.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors,Long> {
}
