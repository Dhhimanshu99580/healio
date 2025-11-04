package org.example.patientsvc.repositories;

import org.example.patientsvc.entities.Appointment;
import org.example.patientsvc.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    boolean existsByDoctorAndDateOfAppointment(Doctors doctor, LocalDateTime dateOfAppointment);
}
