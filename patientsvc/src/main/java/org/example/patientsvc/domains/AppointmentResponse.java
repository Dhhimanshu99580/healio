package org.example.patientsvc.domains;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long appointmentId;
    private LocalDateTime dateOfAppointment;
    private String nameOfDoctor;
}
