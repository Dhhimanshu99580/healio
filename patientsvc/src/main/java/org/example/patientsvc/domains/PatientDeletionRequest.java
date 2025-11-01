package org.example.patientsvc.domains;

import lombok.Data;

import java.util.UUID;

@Data
public class PatientDeletionRequest {
    private UUID id;
    private String name;
}
