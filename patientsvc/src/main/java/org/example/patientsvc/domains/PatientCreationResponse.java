package org.example.patientsvc.domains;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PatientCreationResponse {
 private UUID patientId;
 private String patientName;
 private String patientEmail;
 private String patientAddress;
 private String patientPhone;
 private LocalDateTime addedOn;
}
