package org.example.patientsvc.domains;

import lombok.Data;

import java.util.UUID;

@Data
public class PatientDeletionResponse {
    private UUID id;
    private String name;
    private String email;
    private String phone;
}
