package org.example.patientsvc.domains;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDTO {
    private final String patientName;
    private final String email;
    private final String patientPhoneNumber;
    private final LocalDate dateOfBirth;

}
