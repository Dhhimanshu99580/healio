package org.example.patientsvc.domains;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDeletionResponse {
    private Long appointmentId;
    private LocalDateTime dateOfAppointment;
    private String doctorName;
    private String patientName;
}

