package org.example.patientsvc.domains;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateAppointmentResponse {
    private UUID patientId;
    private Long appointmentId;
    private String message;
}
