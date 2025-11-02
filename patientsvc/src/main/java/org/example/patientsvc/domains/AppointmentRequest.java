package org.example.patientsvc.domains;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentRequest {
    private LocalDateTime dateOfAppointment;
    private Long doctorId;
    private UUID patientId;
}
