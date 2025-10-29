package org.example.patientsvc.domains;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UpdatePatientDetails {
    private String address;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;
    private UUID id;
    private String name;
}
